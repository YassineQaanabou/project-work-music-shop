package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.repository.AcquistoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/acquisti")
public class AdminAcquistoController {
    @Autowired
    private AcquistoRepository acquistoRepository;
@GetMapping
    public String index(Model model){
    // prendo la lista degli acquisti

    // la passo al tempalte
    model.addAttribute("flag",acquistoRepository.findAll().size());
    model.addAttribute("acquisti",acquistoRepository.findAll());
    return "admin/acquisti/list";

}
}
