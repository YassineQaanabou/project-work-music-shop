package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.Utils;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TipologiaRepository tipologiaRepository;
    @GetMapping
    public String adminPage(){
        return "admin/admin-page";
    }
    //  CRUD PER LE TIPOLOGIE DALL ADMIN
    // mostra le tipologie
    @GetMapping("/tipologie")
    public String list(Model model){
        List<Tipologia> tipologieList=tipologiaRepository.findAll();
        model.addAttribute("tipologie",tipologieList);
        return "admin/tipologie/list";
    }
    // crea una tipologia
    @GetMapping("/tipologie/crea")
    public String create(Model model){
        model.addAttribute("tipologia",new Tipologia());
        return "admin/tipologie/form";
    }
    @PostMapping("/tipologie/crea")
    public String doCreate(@Valid @ModelAttribute("tipologia") Tipologia formTipologia,
                           BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "admin/tipologie/form";
        }
        // set slug
        formTipologia.setSlug(Utils.getSlug(formTipologia.getNome()));
        // salvo nel db
        tipologiaRepository.save(formTipologia);
        return "redirect:/admin/tipologie";

    }
    // modifica una tipologia
    // elimina una tipologia
}
