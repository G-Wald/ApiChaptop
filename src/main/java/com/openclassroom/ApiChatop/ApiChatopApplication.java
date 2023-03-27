package com.openclassroom.ApiChatop;

import com.openclassroom.ApiChatop.controller.MessagesController;
import com.openclassroom.ApiChatop.controller.RentalsController;
import com.openclassroom.ApiChatop.controller.UsersController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses= UsersController.class)
@ComponentScan(basePackageClasses= RentalsController.class)
@ComponentScan(basePackageClasses= MessagesController.class)
@EnableJpaRepositories("com.openclassroom.ApiChatop.repository")
@ComponentScan(basePackages = { "com.openclassroom.ApiChatop.service"})
@EntityScan("com.openclassroom.ApiChatop.model")
public class ApiChatopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiChatopApplication.class, args);
	}

}
