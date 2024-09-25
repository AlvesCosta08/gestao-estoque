package com.gestao_estoque.gestao_estoque.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')") // Apenas ADMIN pode acessar
    public String dashboard(Model model) {
        // Aqui você pode adicionar informações necessárias para o dashboard
        return "dashboard";
    }
}
