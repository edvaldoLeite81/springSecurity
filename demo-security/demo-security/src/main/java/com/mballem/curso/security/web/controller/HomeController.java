package com.mballem.curso.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

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
        model.addAttribute("texto","Usuário e/ou senha incorreta(s). Por favor, revise e tente novamente.");
        model.addAttribute("subtexto","Acesso permitido apenas para cadastros já ativados");

        return "login";
    }


    // acesso negado
    @GetMapping({"/acesso-negado"})
    public String acessoNegado(ModelMap model, HttpServletResponse response) {
        model.addAttribute("status",response.getStatus());
        model.addAttribute("error","Forbidden");
        model.addAttribute("message","O servidor entendeu a solicitação, mas se recusa a autorizá-la.");


        return "error";
    }
}
