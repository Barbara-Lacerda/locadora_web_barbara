package br.com.locadora.locadora_web_barbara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //informa ao Spring que a classe recebe acesso do navegador.

public class HomeController {
    @GetMapping("/")
    public String abrirPaginaInicial(){
        return "index";
    }

}