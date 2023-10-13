package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Assortimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AssortimentoRepository extends JpaRepository<Assortimento, Integer> {
    List<Assortimento> findByDataBetween(LocalDate startDate, LocalDate endDate);

}
