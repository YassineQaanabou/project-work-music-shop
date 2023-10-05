package com.projectwork.shopstrumentimusicali.shop.controller;


import com.projectwork.shopstrumentimusicali.shop.Utils;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{slug}/edit")
    public String edit(Model model , @PathVariable("slug") String slug){
        // prendo l optional ny slug
        Optional<Strumento> result= strumentoRepository.findBySlug(slug);
        // controllo dell optional
        if (result.isPresent()){
            // prendo la lista delle tipolodie
            List<Tipologia> tipologieList=tipologiaRepository.findAll();
            // passo lo strumento vuoto e le tipologie al form
            model.addAttribute("tipologie", tipologieList);
            model.addAttribute("strumento",result.get());
            return "admin/strumenti/form"; // template
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "strumento con slug " + slug + " non trovata");

        }



    }

    @PostMapping("/{slug}/edit")
    public String doEdit(@PathVariable("slug") String slug,@Valid @ModelAttribute("strumento") Strumento formStrumento,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {


            return "admin/strumenti/form";
        }
        // trovo la tipologia
        Strumento strumento= strumentoRepository.findBySlug(slug).get();
       // formStrumento.setTipologia(strumento.getTipologia());

        // salvo lo slug nell formStrumento
        formStrumento.setSlug(Utils.getSlug(formStrumento.getNome()));
        formStrumento.setId(strumento.getId());
        System.out.println(formStrumento.getTipologia().getNome());
        // salvo nel db
        strumentoRepository.save(formStrumento);
        return "redirect:/admin/strumenti";
    }
    // elimina strumeno
    @PostMapping("/{slug}/delete")
    public String delete(@PathVariable("slug") String slug) {
        // legge  strumento dal path
        Optional<Strumento> result= strumentoRepository.findBySlug(slug);
        if (result.isPresent()){
            int userId= result.get().getId();
            // cancella lo User da database
            strumentoRepository.deleteById(userId);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "strumento con slug " + slug + " non trovata");

        }

        // fa una redirect alla lista di User
        return "redirect:/admin/strumenti";
    }
}
