package com.gestao_estoque.gestao_estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam String username, @RequestParam String password) {
        // Autenticação do usuário deve ser realizada aqui
        // (O Spring Security fará isso, então você não precisa implementar lógica adicional aqui)
        return "redirect:/home"; // Redirecionar para home após login
    }
}
