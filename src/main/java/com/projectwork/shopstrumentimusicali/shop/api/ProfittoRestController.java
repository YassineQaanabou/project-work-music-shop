package com.projectwork.shopstrumentimusicali.shop.api;

import com.projectwork.shopstrumentimusicali.shop.dto.ProfittoDto;
import com.projectwork.shopstrumentimusicali.shop.service.ProfittoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class ProfittoRestController {
    @Autowired
    private ProfittoService profittoService;

    @GetMapping("/profitto")
    public List<ProfittoDto> getProfitto(@RequestParam("time") String time) {
        if (time.equals("2")) {

            return profittoService.getProfittoLastMonth();
        } else if (time.equals("1")) {
            return profittoService.getProfitto();

        } else {
            return profittoService.getProfitto();
        }

    }

}
