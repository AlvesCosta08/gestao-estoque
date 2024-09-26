package com.gestao_estoque.gestao_estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard"; // Retorna o nome da visualização para a página do dashboard
    }
}
