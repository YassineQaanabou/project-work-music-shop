package com.projectwork.shopstrumentimusicali.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AcquistoController {

    @GetMapping("/{slugTipo}/{slugStrum}/acquista")

    public String create(Model model, @PathVariable("slugTipo") String slugTipo,@PathVariable("slugStrum") String slugStrum){
        //passo un acquisto vuoto
        return null;
    }
    @GetMapping("/{slugTipo}/{slugStrum}/acquista")

    public String doCreate(Model model,
                           @PathVariable("slugTipo") String slugTipo,
                           @PathVariable("slugStrum") String slugStrum){
        //passo un acquisto vuoto
        return null;
    }


}
