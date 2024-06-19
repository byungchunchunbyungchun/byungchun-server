package xyz.byungjun.byungchunchunbyungchun.meal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.byungjun.byungchunchunbyungchun.core.dto.BaseDTO;
import xyz.byungjun.byungchunchunbyungchun.meal.client.response.MealResponse;
import xyz.byungjun.byungchunchunbyungchun.meal.dto.MealDTO;
import xyz.byungjun.byungchunchunbyungchun.meal.service.MealService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping("/today")
    public BaseDTO<List<MealDTO>> today() throws IOException, GeneralSecurityException {
        return new BaseDTO<>(200,  mealService.getTodayMeals());
    }
}