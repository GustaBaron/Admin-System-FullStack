package com.Sneaker_Collection.controller;

import com.Sneaker_Collection.service.TenisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe responsável por lidar com as requisições HTTP
 * A classe deve chamar o service para alguma lógica de negócio.
 * Nunca acesse Repository diretamente.
 */
@Controller
@RequestMapping("/tenis2")
public class TenisDinamicoController {


    //@Autowired -> Evite utilizar injeção via atributo
    // use via construtor
    private final TenisService tenisService;

    /**
     * Injeção de dependencia via construtor
     * @paramtenisService
     */
    public TenisDinamicoController(TenisService tenisService) {
        this.tenisService = tenisService;
    }

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("tenis/lista_dinamica");
        var lista = tenisService.findAll();
        // Adiciona a lista de paises na view com o nome 'paises'
        mv.addObject("tenis", lista);
        return mv;
    }

    @GetMapping
    @RequestMapping("/aleatorio")
    public ModelAndView aleatorio() {
        var optional = tenisService.obterUmTenisAleatoriamente();
        // Caso não exista países cadastrados, retorna uma mensagem de erro
        if(optional.isEmpty()){
            return new ModelAndView("tenis/nao_ha_tenis");
        }
        // Adiciona o objeto tenis na view com o nome 'tenis'
        var mv = new ModelAndView("tenis/tenis_aleatorio");
        mv.addObject("tenis", optional.get());
        return mv;
    }



}