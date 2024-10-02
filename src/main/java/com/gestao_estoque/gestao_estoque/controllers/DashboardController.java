package com.gestao_estoque.gestao_estoque.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("title", "Dashboard");
        return "dashboard";
    }
}
