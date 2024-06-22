package xyz.byungjun.byungchunchunbyungchun.meal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.byungjun.byungchunchunbyungchun.meal.client.response.MealResponse;


@FeignClient(name = "mailgun", url = "https://dodamapi.b1nd.com")
public interface MealClient {
    @GetMapping("/meal")
    MealResponse getMeal(
            @RequestParam("year") String year,
            @RequestParam("month") String month,
            @RequestParam("day") String day
    );
}
