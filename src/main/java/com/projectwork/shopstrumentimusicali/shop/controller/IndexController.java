package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import com.projectwork.shopstrumentimusicali.shop.model.Magazzino;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.MagazzinoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private AcquistoRepository acquistoRepository;
    @Autowired
    private StrumentoRepository strumentoRepository;
    @Autowired
    private TipologiaRepository tipologiaRepository;

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    // homepage
    @GetMapping
    public String homepage(Model model) {
        List<Strumento> strumentiPiuVendutiMese = strumentoRepository.findTopSellingInLastMonth(LocalDate.now().minusMonths(1));

        model.addAttribute("strumentiPiuVendutiMese", strumentiPiuVendutiMese);

        List<Tipologia> tipologie = tipologiaRepository.findAll();

        model.addAttribute("tipologie", tipologie);
        return "homepage";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        List<Strumento> strumenti = strumentoRepository.findAll();
        model.addAttribute("strumenti", strumenti);
        return "customer/strumenti/list";
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
        model.addAttribute("tipologia", tipologiaRepository.findBySlug(tipologiaSlug).get());

        model.addAttribute("acquisto", new Acquisto());
        return "customer/strumenti/details";

    }

    @PostMapping("/{tipologiaSlug}/{strumentoSlug}")

    public String doBuy(@Valid @ModelAttribute("acquisto") Acquisto formAcquisto, BindingResult bindingResult, @PathVariable("tipologiaSlug") String tipologiaSlug, @PathVariable("strumentoSlug") String strumentoSlug, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tipologia", tipologiaRepository.findBySlug(tipologiaSlug).get());
            model.addAttribute("strumento", strumentoRepository.findBySlug(strumentoSlug).get());
            return "customer/strumenti/details";
        }
        // aggiungo lo strumento
        formAcquisto.setStrumento(strumentoRepository.findBySlug(strumentoSlug).get());
        // setto la data
        formAcquisto.setDataAcquisto(LocalDate.now());
        // salvo nel db
        acquistoRepository.save(formAcquisto);
        // modifico la quantita disponibile magazzione
        Strumento strumentoResult = strumentoRepository.findBySlug(strumentoSlug).get();
        Magazzino magazzino = magazzinoRepository.findByStrumento(strumentoResult).get();
        magazzino.setQuantity(magazzino.getQuantity() - formAcquisto.getQuantity());
        magazzino.setId(magazzino.getId());
        magazzinoRepository.save(magazzino);
        return "redirect:/";

    }

    @GetMapping("/cerca")
    public String cercaStrumento(@RequestParam("q") String searchString, Model model) {

        List<Strumento> strumentiTrovati = strumentoRepository.findByCustomSearchQuery(searchString);

        model.addAttribute("strumenti", strumentiTrovati);

        return "customer/strumenti/list";
    }

}