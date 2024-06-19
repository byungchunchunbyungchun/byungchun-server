package xyz.byungjun.byungchunchunbyungchun.meal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.byungjun.byungchunchunbyungchun.meal.client.response.MealResponse;

@FeignClient(name = "mailgun", url = "https://dodamapi.b1nd.com")
public interface MealClient {
    @GetMapping("/meal")
    public MealResponse getMeal(
            @RequestParam String year,
            @RequestParam String month,
            @RequestParam String day
    );
}
