package com.projectwork.shopstrumentimusicali.shop.controller;


import com.projectwork.shopstrumentimusicali.shop.model.*;
import com.projectwork.shopstrumentimusicali.shop.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AssortimentoController {
    @Autowired
    private AssortimentoRepository assortimentoRepository;
    @Autowired
    private StrumentoRepository strumentoRepository;
    @Autowired
    private TipologiaRepository tipologiaRepository;

    @Autowired
    private MagazzinoRepository magazzinoRepository;
    @Autowired
    private FornitoreStrumentoRepository fornitoreStrumentoRepository;
    @Autowired
    private FornitoreRepository fornitoreRepository;

    @GetMapping("/admin/assortimenti")
    public String list(Model model) {
        model.addAttribute("assortimenti", assortimentoRepository.findAll());
        model.addAttribute("size", assortimentoRepository.findAll().size());
        return "/admin/assortimenti/list";
    }


    @GetMapping("admin/{slugTipo}/{slugNome}/assortimento")
    public String ordina(Model model, @PathVariable("slugNome") String slugNome, @PathVariable("slugTipo") String slugTipo) {
        Strumento strumento = strumentoRepository.findBySlug(slugNome).get();
        List<FornitoreStrumento> fornitoreStrumento = strumento.getFornitoreStrumento();
        List<Fornitore> fornitori = new ArrayList<>();
        for (FornitoreStrumento value : fornitoreStrumento) {
            fornitori.add(value.getFornitore());
        }
        model.addAttribute("fornitori", fornitori);
        model.addAttribute("fornitoriStrumento", fornitoreStrumento);
        // passo al modello strumento e tipologia
        model.addAttribute("strumento", strumento);
        model.addAttribute("tipologia", tipologiaRepository.findBySlug(slugTipo).get());
        // passo alla post il modello assortimento
        model.addAttribute("assortimento", new Assortimento());
        return "/admin/assortimenti/form";

    }

    @PostMapping("admin/{slugTipo}/{slugNome}/assortimento")
    public String doOrdina(@Valid @ModelAttribute("assortimento") Assortimento assortimentoForm, Model model, @PathVariable("slugNome") String slugNome, @PathVariable("slugTipo") String slugTipo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/admin/assortimenti/form";
        }

        Strumento strumento = strumentoRepository.findBySlug(slugNome).get();
        FornitoreStrumento fornitura = fornitoreStrumentoRepository.findByFornitoreIdAndStrumentoId(assortimentoForm.getFornitore().getId(), strumento.getId());

        // setto la data
        assortimentoForm.setData(LocalDate.now());
        // setto lo strumento
        assortimentoForm.setStrumento(strumento);
        // calcolo e setto il prezzo (prezzo * quantity)
        BigDecimal result = fornitura.getPrezzo();
        BigDecimal totale = result.multiply(BigDecimal.valueOf(assortimentoForm.getQuantity()));
        assortimentoForm.setTotale(totale);
        // salvo nel db
        assortimentoRepository.save(assortimentoForm);
        // aumento le quantità in magazzino
        Magazzino magazzino = magazzinoRepository.findByStrumento(strumento).get();
        magazzino.setQuantity(magazzino.getQuantity() + assortimentoForm.getQuantity());
        magazzino.setId(magazzino.getId());
        magazzinoRepository.save(magazzino);


        return "redirect:/admin";

    }

}
