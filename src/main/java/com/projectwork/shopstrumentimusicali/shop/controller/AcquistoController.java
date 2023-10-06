package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AcquistoController {
     @Autowired
     private StrumentoRepository strumentoRepository;
     @Autowired
     private TipologiaRepository tipologiaRepository;
    @GetMapping("/{slugTipo}/{slugStrum}/acquista")

    public String create(Model model, @PathVariable("slugTipo") String slugTipo,@PathVariable("slugStrum") String slugStrum){
        //prendo strumento e tipo
        model.addAttribute("strumento",strumentoRepository.findBySlug(slugStrum).get());
        model.addAttribute("tipologia",tipologiaRepository.findBySlug(slugTipo).get());
         //passo un acquisto vuoto
        Acquisto acquisto = new Acquisto();
        acquisto.setQuantità(1);
        model.addAttribute("acquisto",acquisto);
        return "customer/acquisti/form";
    }
    @PostMapping("/{slugTipo}/{slugStrum}/acquista")

    public String doCreate(Model model,
                           @PathVariable("slugTipo") String slugTipo,
                           @PathVariable("slugStrum") String slugStrum,
                           BindingResult bindingResult,
                           @Valid @ModelAttribute("acquisto") Acquisto acquistoForm
    ){
        //prendo strumento e tipo
        // form da cui prendo email dati utente e quiantita
        // creu un utente con l email
        // setto l utente appena creato (find by email) nell acquistoform
        // setto lo strumento nell acquisto form
        // setto la quantita


        return "customer/acquisti/form";
    }


}
