package xyz.byungjun.byungchunchunbyungchun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ByungchunchunbyungchunApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByungchunchunbyungchunApplication.class, args);
	}

}
