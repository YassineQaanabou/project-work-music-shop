package com.projectwork.shopstrumentimusicali.shop.controller;

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
@RequestMapping("/admin/fornitura")
public class FornitoreStrumentoController {
    @Autowired
    private FornitoreRepository fornitoreRepository;
    @Autowired
    private StrumentoRepository strumentoRepository;
    @Autowired
    private FornitoreStrumentoRepository fornitoreStrumentoRepository;

    @GetMapping("/{slug}/crea")
    public String create(Model model, @PathVariable("slug") String slug) {
        List<Strumento> strumentiList = strumentoRepository.findAll();
        Optional<Fornitore> fornitore = fornitoreRepository.findBySlug(slug);
        model.addAttribute("strumenti", strumentiList);
        model.addAttribute("fornitore", fornitore.get());
        model.addAttribute("fornitura", new FornitoreStrumento());

        return "fornitura/form";
    }

    @PostMapping("/{slug}/crea")
    public String doCreate(@Valid @ModelAttribute("fornitura") FornitoreStrumento formFornitura, @PathVariable("slug") String slug,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {


            return "fornitura/form";
        }
        Optional<Fornitore> fornitore = fornitoreRepository.findBySlug(slug);

        formFornitura.setFornitore(fornitore.get());
        fornitoreStrumentoRepository.save(formFornitura);

        return "redirect:/admin/fornitore";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        Optional<FornitoreStrumento> result = fornitoreStrumentoRepository.findById(id);
        if (result.isPresent()) {
            fornitoreStrumentoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "fornitura con id " + id + " non trovata");

        }

        return "redirect:/admin/fornitore";
    }

}
