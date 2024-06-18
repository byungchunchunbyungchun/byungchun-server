package xyz.byungjun.byungchunchunbyungchun.meal.client.response;

import java.util.List;

public record MealResponse(
        MealData data
) {
    public record MealData(
            String date,
            MealDetail breakfast,
            MealDetail lunch,
            MealDetail dinner
    ){}
    public record MealDetail(
            List<MealContent> details
    ){}

    public record MealContent(
            String name
    ){}
}