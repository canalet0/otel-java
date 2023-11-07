package com.example.oteljava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OtelJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtelJavaApplication.class, args);
	}

}
