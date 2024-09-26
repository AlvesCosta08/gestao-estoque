package com.gestao_estoque.gestao_estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna o nome da visualização para a página de login
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout"; // Retorna o nome da visualização para a página de logout
    }
}

