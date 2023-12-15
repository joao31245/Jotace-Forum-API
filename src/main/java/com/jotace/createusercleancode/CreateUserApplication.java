package com.jotace.createusercleancode;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Jotace Forum", version = "1", description = "My programming forum"))
@CrossOrigin(origins = "*")
public class CreateUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateUserApplication.class, args);
	}

}
