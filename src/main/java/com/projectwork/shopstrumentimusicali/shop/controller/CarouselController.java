package com.projectwork.shopstrumentimusicali.shop.controller;

import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.repository.StrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

public class CarouselController {
    @Autowired
    private StrumentoRepository strumentoRepository;
@GetMapping("/carousel")
    public String carousel () {

        List<Strumento> imageUrls = strumentoRepository.findByCustomSearchQueryName("chitarra");
       // model.addAttribute("strumento", imageUrls);
        return "carousel";
    }
}
