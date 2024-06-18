package xyz.byungjun.byungchunchunbyungchun.meal.service;

import xyz.byungjun.byungchunchunbyungchun.meal.dto.MealDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface MealService {

    List<MealDTO> getTodayMeals() throws IOException, GeneralSecurityException;

}
