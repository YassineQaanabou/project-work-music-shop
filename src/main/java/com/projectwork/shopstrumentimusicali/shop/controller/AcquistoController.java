package com.projectwork.shopstrumentimusicali.shop.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AcquistoController {

    @GetMapping("/{slugTipo}/{slugStrum}/acquista")

    public String create(Model model, @PathVariable("slugTipo") String slugTipo,@PathVariable("slugStrum") String slugStrum){
        //passo un acquisto vuoto
        return null;
    }
    @PostMapping("/{slugTipo}/{slugStrum}/acquista")

    public String doCreate(Model model,
                           @PathVariable("slugTipo") String slugTipo,
                           @PathVariable("slugStrum") String slugStrum,
                           BindingResult bindingResult,
                           @Valid @ModelAttribute("acquisto") Acquisto acquistoForm
    ){
        //prendo utente e lo setto nell' acquisto
        // prendo lo strumento e lo setto nell' acquisto

        return null;
    }


}
