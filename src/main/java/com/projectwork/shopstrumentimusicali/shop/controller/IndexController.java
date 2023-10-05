package com.projectwork.shopstrumentimusicali.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    // homepage
    @GetMapping
    public  String homepage(){
        return "homepage";
    }
    // {nome categoria}
    // /{nc}/{nome strumento}
    // /i-nostri-strumenti
}
