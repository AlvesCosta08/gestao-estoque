package com.gestao_estoque.gestao_estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gestao_estoque.gestao_estoque.repository")
public class GestaoEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoEstoqueApplication.class, args);
	}

}
