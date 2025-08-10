package com.karanchuk.roomwebapp;

import com.karanchuk.roomwebapp.data.repository.EmployeeRepository;
import com.karanchuk.roomwebapp.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomWebAppApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(RoomRepository roomRepository, EmployeeRepository employeeRepository) {
//		return args -> {
//			System.out.println("Rooms:");
//			roomRepository.findAll().forEach(System.out::println);
//			System.out.println("Staff:");
//			employeeRepository.findAll().forEach(System.out::println);
//		};
//	}
}
