package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipologiaRepository extends JpaRepository<Tipologia, Integer>{
    public Tipologia findBySlug(String slug);
}
