package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tipologie")
public class TipologiaController {

    @Autowired
  TipologiaRepository tipologiaRepository;
@GetMapping
    public String tipologiaPage(Model model){
        model.addAttribute("listaTipologie", tipologiaRepository.findAll());
        model.addAttribute("tipologiaObj", new Tipologia());
        return "tipologia/page";
    }

@PostMapping("/tipologia-save")
public String doCreate(@Valid @ModelAttribute("tipologiaObj") Tipologia tipologiaForm,
                       RedirectAttributes redirectAttributes) {

tipologiaRepository.save(tipologiaForm);

    return "redirect:/tipologia";
}
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        tipologiaRepository.deleteById(id);

        return "redirect:/tipologia";
    }
}
