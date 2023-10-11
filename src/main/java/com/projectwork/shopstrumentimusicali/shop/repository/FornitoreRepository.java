package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Fornitore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornitoreRepository extends JpaRepository<Fornitore, Integer> {
    Optional<Fornitore> findBySlug(String slug);

}
