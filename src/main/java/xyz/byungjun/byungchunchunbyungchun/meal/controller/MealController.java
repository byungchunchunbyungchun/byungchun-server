package xyz.byungjun.byungchunchunbyungchun.meal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.byungjun.byungchunchunbyungchun.core.dto.BaseDTO;
import xyz.byungjun.byungchunchunbyungchun.meal.client.response.MealResponse;
import xyz.byungjun.byungchunchunbyungchun.meal.dto.MealDTO;
import xyz.byungjun.byungchunchunbyungchun.meal.service.MealService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3002")
@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping("/today")
    public BaseDTO<List<MealDTO>> today() throws IOException, GeneralSecurityException {
        LocalDate date = LocalDate.now();
        return new BaseDTO<>(200,  mealService.getMeal(date));
    }

    @GetMapping("/get")
    public BaseDTO<List<MealDTO>> today(
            @RequestParam("year") Integer year,
            @RequestParam("month") Integer month,
            @RequestParam("day") Integer day
    ) throws IOException, GeneralSecurityException {
        LocalDate date = LocalDate.of(year, month, day);
        return new BaseDTO<>(200,  mealService.getMeal(date));
    }

    @GetMapping("/one")
    public BaseDTO<MealDTO> today(
            @RequestParam("mealId") Long mealId
    ) throws IOException, GeneralSecurityException {
        return new BaseDTO<>(200,  mealService.getMealById(mealId));
    }
}