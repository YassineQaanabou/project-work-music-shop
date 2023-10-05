package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private TipologiaRepository tipologiaRepository;
    // homepage
    @GetMapping
    public  String homepage(Model model){
        model.addAttribute("tipologie",tipologiaRepository.findAll());
        return "homepage";
    }
    // {nome categoria}
    // /{nc}/{nome strumento}
    // /i-nostri-strumenti
}
