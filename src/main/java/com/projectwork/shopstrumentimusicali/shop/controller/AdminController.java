package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TipologiaController tipologiaController;
    @GetMapping
    public String adminPage(){
        return "admin/admin-page";
    }
    //  CRUD PER LE TIPOLOGIE DALL ADMIN
    // mostra le tipologie
    @GetMapping("/tipologie")
    public String list(Model model){
        List<Tipologia> tipologieList=tipologiaController.tipologiaRepository.findAll();
        model.addAttribute("tipologie",tipologieList);
        return "admin/tipologie/list";
    }
    // crea una tipologia
    // modifica una tipologia
    // elimina una tipologia
}
