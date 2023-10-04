package com.projectwork.shopstrumentimusicali.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/tipologia")
public class TipologiaController {

@GetMapping
    public String tipologiaPage(Model model){
model.addAttribute("listaTipologie", tipologiaRepository.findAll());
model.addAttribute("tipologiaObj", new Tipologia);
return "tipolgia/page";
    }


}
