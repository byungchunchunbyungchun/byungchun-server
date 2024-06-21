package xyz.byungjun.byungchunchunbyungchun.meal.service;

import xyz.byungjun.byungchunchunbyungchun.meal.dto.MealDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.List;

public interface MealService {

    List<MealDTO> getMeal(LocalDate date) throws IOException, GeneralSecurityException;

    MealDTO getMealById(Long mealId);

}
