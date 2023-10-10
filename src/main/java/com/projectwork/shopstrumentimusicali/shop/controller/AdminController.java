package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.Utils;
import com.projectwork.shopstrumentimusicali.shop.model.Magazzino;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.MagazzinoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TipologiaRepository tipologiaRepository;
    @Autowired
    private StrumentoRepository strumentoRepository;
    @Autowired
    private MagazzinoRepository magazzinoRepository;

    @GetMapping
    public String adminPage() {
        return "admin/admin-page";
    }

    //  CRUD PER LE TIPOLOGIE DALL ADMIN
    // mostra le tipologie
    @GetMapping("/tipologie")
    public String list(Model model) {
        List<Tipologia> tipologieList = tipologiaRepository.findAll();
        model.addAttribute("tipologie", tipologieList);
        return "admin/tipologie/list";
    }

    // crea una tipologia
    @GetMapping("/tipologie/crea")
    public String create(Model model) {
        model.addAttribute("tipologia", new Tipologia());
        return "admin/tipologie/form";
    }

    @PostMapping("/tipologie/crea")
    public String doCreate(@Valid @ModelAttribute("tipologia") Tipologia formTipologia,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/tipologie/form";
        }
        // set slug
        formTipologia.setSlug(Utils.getSlug(formTipologia.getNome()));
        // salvo nel db
        tipologiaRepository.save(formTipologia);
        return "redirect:/admin/tipologie";

    }

    // modifica una tipologia
    @GetMapping("/tipologie/{slug}/edit")
    public String edit(@PathVariable("slug") String slug, Model model) {
        // cerco tipologie slug
        Optional<Tipologia> result = tipologiaRepository.findBySlug(slug);
        if (result.isPresent()) {
            model.addAttribute("tipologia", result.get());
            return "admin/tipologie/form";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tipologia con slug " + slug + " non trovata");

        }
    }

    @PostMapping("/tipologie/{slug}/edit")
    public String doEdit(@PathVariable("slug") String slug, @Valid @ModelAttribute("strumento") Tipologia formTipologia,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/tipologie/form";

        }
        // prendiamo id tipologia
        Tipologia tipo = tipologiaRepository.findBySlug(slug).get();
        // setto la tipologia
        formTipologia.setId(tipo.getId());
        tipologiaRepository.save(formTipologia);
        return "redirect:/admin/strumenti";


    }

    // elimina una tipologia
    @PostMapping("/tipologie/{slug}/delete")
    public String delete(@PathVariable("slug") String slug) {
        // legge  strumento dal path
        Optional<Tipologia> result = tipologiaRepository.findBySlug(slug);
        if (result.isPresent()) {
            // trovo tutti gli strumenti per categoria

            // cancello la categoria associata a tali strumenti
            List<Strumento> strumentiTipoList = strumentoRepository.findByTipologia(result.get());
            // itero nella lista e per ogni strumento setto la categoria null
            for (Strumento strumento : strumentiTipoList) {
                strumento.setTipologia(null);

            }

            //  elimino la categoria
            result.get().setStrumenti(null);
            int tipoId = result.get().getId();

            tipologiaRepository.deleteById(tipoId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tipologia con slug " + slug + " non trovata");

        }

        // fa una redirect alla lista di User
        return "redirect:/admin/tipologie";
    }

    @GetMapping("/cerca-per-nome")
    public String cercaStrumento(
            @RequestParam(value = "q", required = false) String searchString,
            Model model
    ) {

        List<Strumento> strumentiTrovati = strumentoRepository.findByCustomSearchQueryName(searchString);


        model.addAttribute("strumenti", strumentiTrovati);

        return "admin/strumenti/list";
    }

    @GetMapping("/cerca-per-quantita")
    public String cercaStrumentoPerQuantita(@RequestParam(value = "quantity", required = false) int quantity, Model model) {
        List<Magazzino> quantitaMagazzini = magazzinoRepository.findByQuantity(quantity);
        List<Strumento> strumentiPerQuantita = new ArrayList<>();

        for (Magazzino magazzino : quantitaMagazzini) {
            Optional<Strumento> strumentoOptional = Optional.ofNullable(magazzino.getStrumento());
            if (strumentoOptional.isPresent()) {
                strumentiPerQuantita.add(strumentoOptional.get());
            } else {
                strumentiPerQuantita = strumentoRepository.findAll();
            }
        }

        model.addAttribute("strumenti", strumentiPerQuantita);

        return "admin/strumenti/list";
    }
    @GetMapping("/cerca-per-tipologia")
    public String cercaPerTipologia(@RequestParam("tipologiaSlug") String tipologiaSlug, Model model) {
        List<Tipologia> listaTipologie = tipologiaRepository.findAll();
        model.addAttribute("tipologie", listaTipologie);
        List<Strumento> strumentiPerTipologia = strumentoRepository.findByTipologiaSlug(tipologiaSlug);

        model.addAttribute("strumenti", strumentiPerTipologia);
        return "admin/strumenti/list";
    }

}
