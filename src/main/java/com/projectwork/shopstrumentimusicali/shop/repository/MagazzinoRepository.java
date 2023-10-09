package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Magazzino;
import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MagazzinoRepository extends JpaRepository<Magazzino,Integer> {
    Optional<Magazzino> findByStrumento(Strumento strumento);
    List<Magazzino> findByQuantity(int quantity);
}
