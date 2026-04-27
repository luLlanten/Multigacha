package com.multigacha.intercambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
@SpringBootApplication
public class IntercambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntercambioApplication.class, args);
	}

}
