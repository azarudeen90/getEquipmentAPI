package com.kone.assignment.equipments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:cloudant.properties")
public class GetEquipmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetEquipmentApiApplication.class, args);
	}
}
