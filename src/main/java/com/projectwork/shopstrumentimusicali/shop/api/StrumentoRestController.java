package com.projectwork.shopstrumentimusicali.shop.api;


import com.projectwork.shopstrumentimusicali.shop.model.Magazzino;
import com.projectwork.shopstrumentimusicali.shop.repository.MagazzinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class StrumentoRestController {
    @Autowired
    private MagazzinoRepository magazzinoRepository;
    @GetMapping("/magazzino")
    public List<Magazzino> magazzinoList(){
        List<Magazzino> list= magazzinoRepository.findAll();
        return  list;
    }
}
