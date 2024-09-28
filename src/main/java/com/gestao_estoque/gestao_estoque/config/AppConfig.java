package com.gestao_estoque.gestao_estoque.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dotenv dotenv() {
        return Dotenv.load();
    }

    @Bean
    public String dbUrl(Dotenv dotenv) {
        return dotenv.get("DB_URL");
    }

    @Bean
    public String dbUsername(Dotenv dotenv) {
        return dotenv.get("DB_USERNAME");
    }

    @Bean
    public String dbPassword(Dotenv dotenv) {
        return dotenv.get("DB_PASSWORD");
    }

    @Bean
    public String secretKey(Dotenv dotenv) {
        return dotenv.get("SECRET_KEY");
    }
}

