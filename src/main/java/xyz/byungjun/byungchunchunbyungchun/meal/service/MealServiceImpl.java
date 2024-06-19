package xyz.byungjun.byungchunchunbyungchun.meal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.byungjun.byungchunchunbyungchun.meal.client.MealClient;
import xyz.byungjun.byungchunchunbyungchun.meal.client.response.MealResponse;
import xyz.byungjun.byungchunchunbyungchun.meal.dto.MealDTO;
import xyz.byungjun.byungchunchunbyungchun.meal.entity.MealEntity;
import xyz.byungjun.byungchunchunbyungchun.meal.repository.MealRepository;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final MealClient mealClient;

    @Value("${neis.api-key}")
    String apiKey = "";

    @Override
    public List<MealDTO> getTodayMeals() throws IOException, GeneralSecurityException {
        LocalDate localDate = LocalDate.now();

        List<MealEntity> result = mealRepository.findAllByDate(localDate);

        // 찾는데 성공한 경우
        if (!result.isEmpty()) {
            return result
                    .stream()
                    .map(MealEntity::toMealDTO)
                    .toList();
        }


        // 실패한 경우
        MealResponse response = mealClient.getMeal(
                String.valueOf(localDate.getYear()),
                String.valueOf(localDate.getMonthValue()),
                String.valueOf(localDate.getDayOfMonth())
        );

        List<MealDTO> mealDTOS = List.of(
                createMealDTO(localDate, response.data().breakfast(), "breakfast"),
                createMealDTO(localDate, response.data().lunch(), "lunch"),
                createMealDTO(localDate, response.data().dinner(), "dinner")
        );

        mealRepository.saveAll(
                mealDTOS
                        .stream()
                        .map(MealDTO::toMealEntity)
                        .toList()
        );

        return mealDTOS;
    }

    private MealDTO createMealDTO(LocalDate date, MealResponse.MealDetail mealDetail, String time) {
        return MealDTO.builder()
                .date(date)
                .meal(mealDataToString(mealDetail))
                .time(time)
                .build();
    }

    private String mealDataToString(MealResponse.MealDetail mealDetail) {
        StringBuilder stringBuilder = new StringBuilder();
        mealDetail.details().forEach(detail -> {
            stringBuilder.append(detail.name()).append("\n");
        });
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
