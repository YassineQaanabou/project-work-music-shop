package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import com.projectwork.shopstrumentimusicali.shop.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class TipologiaRestController {

    @Autowired
    private TipologiaRepository tipologiaRepository;

    @GetMapping("/tipologie")
    public List<Tipologia> tipoListJson(){
        return tipologiaRepository.findAll();
    }
}
