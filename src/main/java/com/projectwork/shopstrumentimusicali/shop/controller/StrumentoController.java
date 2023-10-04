package com.projectwork.shopstrumentimusicali.shop.controller;


import com.projectwork.shopstrumentimusicali.shop.Utils;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/strumenti")
public class StrumentoController {
    @Autowired
    private StrumentoRepository strumentoRepository;
    @Autowired
    private TipologiaRepository tipologiaRepository;
    // mostra strumenti
    @GetMapping
    public String list(Model model){
        // prendo la lista degli strumenti
        List<Strumento> listStrumenti = strumentoRepository.findAll();
        // salvo nel modello
        model.addAttribute("strumenti",listStrumenti);
        // ritorno il template
        return "/admin/strumenti/list";

    }
    // crea strumetno
    @GetMapping("/crea")

    public String create(Model model){
        // prendo la lista delle tipolodie
        List<Tipologia> tipologieList=tipologiaRepository.findAll();
        // passo lo strumento vuoto e le tipologie al form
        model.addAttribute("tipologie", tipologieList);
        model.addAttribute("strumento", new Strumento());

        return "admin/strumenti/form"; // template
    }
    @PostMapping("/crea")
    public String doCreate(@Valid @ModelAttribute("strumento") Strumento formStrumento,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {


            return "admin/strumenti/form";
        }
        // salvo lo slug nell formStrumento
        formStrumento.setSlug(Utils.getSlug(formStrumento.getNome()));
        // salvo nel db
        strumentoRepository.save(formStrumento);
        return "redirect:/admin/strumenti";
    }
    // modifica strumento
    // elimina strumeno

}
