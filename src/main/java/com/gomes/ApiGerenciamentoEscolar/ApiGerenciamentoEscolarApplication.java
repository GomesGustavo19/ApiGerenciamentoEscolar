package com.gomes.ApiGerenciamentoEscolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.gomes.ApiGerenciamentoEscolar.repository")
@SpringBootApplication
public class ApiGerenciamentoEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGerenciamentoEscolarApplication.class, args);
	}

}
