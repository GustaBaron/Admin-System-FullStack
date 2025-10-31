package com.Sneaker_Collection.controller;


import com.Sneaker_Collection.service.TenisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private final TenisService tenisService;

    public HomeController(TenisService tenisService) {
        this.tenisService = tenisService;
    }

    // Mapeia a url raiz para o arquivo html home.html
    // GET
    @GetMapping
    public String home() {
        // Retorna o nome do arquivo html
        // resources/templates/home.html
        return "index";
    }

    @GetMapping
    @RequestMapping("/criar-tenis")
    public ModelAndView criarTenis() {
        tenisService.adicionarTenis();
        // Redireciona para a url raiz
        return new ModelAndView("redirect:/tenis2");
    }

    @GetMapping
    @RequestMapping("/deletar-tenis")
    public ModelAndView deletarTenis() {
        tenisService.deletarTudo();
        // Redireciona para a url raiz
        return new ModelAndView("redirect:/tenis2");
    }

}
