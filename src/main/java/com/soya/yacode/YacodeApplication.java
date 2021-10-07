package com.soya.yacode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.soya"})
public class YacodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YacodeApplication.class, args);
	}

}
