package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.Utils;
import com.projectwork.shopstrumentimusicali.shop.model.Fornitore;
import com.projectwork.shopstrumentimusicali.shop.model.FornitoreStrumento;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.repository.FornitoreRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.FornitoreStrumentoRepository;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fornitore")
public class FornitoreController {

    @Autowired
    private FornitoreRepository fornitoreRepository;

    @Autowired
    private FornitoreStrumentoRepository fornitoreStrumentoRepository;
    @Autowired
    private StrumentoRepository strumentoRepository;

    @GetMapping
    public String list(Model model) {
        List<Fornitore> fornitoreList = fornitoreRepository.findAll();
        model.addAttribute("fornitori", fornitoreList);
        return "fornitore/list";
    }

    @GetMapping("/{slug}")
    public String detailStrumento(@PathVariable("slug") String slug, Model model) {
        Optional<Fornitore> fornitore = fornitoreRepository.findBySlug(slug);
        List<FornitoreStrumento> list = fornitoreStrumentoRepository.findByFornitoreId(fornitoreRepository.findBySlug(slug).get().getId());

        model.addAttribute("list", list);

        model.addAttribute("fornitore", fornitore.get());

        return "fornitore/details";

    }

    @GetMapping("/crea")

    public String create(Model model) {
        List<Strumento> strumentiList = strumentoRepository.findAll();
        model.addAttribute("strumenti", strumentiList);
        model.addAttribute("fornitore", new Fornitore());

        return "fornitore/form";
    }

    @PostMapping("/crea")
    public String doCreate(@Valid @ModelAttribute("fornitore") Fornitore formFornitore,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {


            return "fornitore/form";
        }

        formFornitore.setSlug(Utils.getSlug(formFornitore.getNome()));
        fornitoreRepository.save(formFornitore);

        return "redirect:/fornitore";
    }

    @GetMapping("/{slug}/edit")
    public String edit(Model model, @PathVariable("slug") String slug) {
        Optional<Fornitore> result = fornitoreRepository.findBySlug(slug);
        if (result.isPresent()) {
            model.addAttribute("strumenti", strumentoRepository.findAll());
            model.addAttribute("fornitore", result.get());
            return "fornitore/edit"; // template
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "fornitore con slug " + slug + " non trovata");

        }


    }

    @PostMapping("/{slug}/edit")
    public String doEdit(@PathVariable("slug") String slug, @Valid @ModelAttribute("strumento") Strumento formStrumento,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {


            return "admin/strumenti/form";
        }
        Strumento strumento = strumentoRepository.findBySlug(slug).get();

        formStrumento.setSlug(Utils.getSlug(formStrumento.getNome()));
        formStrumento.setId(strumento.getId());
        System.out.println(formStrumento.getTipologia().getNome());
        strumentoRepository.save(formStrumento);
        return "redirect:/admin/strumenti";
    }

    @PostMapping("/{slug}/delete")
    public String delete(@PathVariable("slug") String slug) {
        Optional<Fornitore> result = fornitoreRepository.findBySlug(slug);
        if (result.isPresent()) {
            int fornitoreId = result.get().getId();
            fornitoreRepository.deleteById(fornitoreId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "fornitore con slug " + slug + " non trovata");

        }

        return "redirect:/fornitore";
    }
}
