package com.gestao_estoque.gestao_estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Adicione os produtos ao model, se necessário
        return "home";
    }
}
