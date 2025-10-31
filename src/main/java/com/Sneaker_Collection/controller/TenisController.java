package com.Sneaker_Collection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tenis")
public class TenisController {

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("tenis/lista_fixa");
        return mv;
    }
}