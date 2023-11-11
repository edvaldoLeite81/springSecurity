package com.mballem.curso.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // abrir pagina home
    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    // login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // login invalido
    @GetMapping({"/login-error"})
    public String logirnError(ModelMap model) {
        model.addAttribute("alerta","erro");
        model.addAttribute("titulo","Credenciais Inválidas");
        model.addAttribute("texto","Usuário ou senha errada, revise e tente novamente.");
        model.addAttribute("subtexto","Acesso permitido apenas para cadastros já ativados");

        return "login";
    }
}
