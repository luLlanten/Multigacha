package com.multigacha.modificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
@SpringBootApplication
public class ModificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModificacionApplication.class, args);
	}

}
