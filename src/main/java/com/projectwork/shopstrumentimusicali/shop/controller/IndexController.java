package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private StrumentoRepository strumentoRepository;
    @Autowired
    private TipologiaRepository tipologiaRepository;

    // homepage
    @GetMapping
    public String homepage(Model model) {
        List<Tipologia> tipologie = tipologiaRepository.findAll();
        model.addAttribute("tipologie", tipologie);
        return "homepage";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        List<Strumento> strumenti = strumentoRepository.findAll();
        model.addAttribute("strumenti", strumenti);
        return "homepage";
    }

    @GetMapping("/{tipologiaSlug}")
    public String strumenti(@PathVariable("tipologiaSlug") String tipologiaSlug, Model model) {
        Optional<Tipologia> tipologiaOptional = tipologiaRepository.findBySlug(tipologiaSlug);
        Tipologia tipologia = tipologiaOptional.get();
        List<Strumento> strumenti = strumentoRepository.findByTipologia(tipologia);
        model.addAttribute("strumenti", strumenti);
        return "customer/strumenti/list";

    }

    @GetMapping("/{tipologiaSlug}/{strumentoSlug}")
    public String detailStrumento(@PathVariable("tipologiaSlug") String tipologiaSlug, @PathVariable("strumentoSlug") String strumentoSlug, Model model) {
        Optional<Strumento> strumentoOptional = strumentoRepository.findBySlug(strumentoSlug);
        Strumento strumento = strumentoOptional.get();
        model.addAttribute("strumento", strumento);
        return "customer/strumenti/detail";

    }
}
