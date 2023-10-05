package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StrumentoRepository extends JpaRepository<Strumento,Integer>  {
    Optional<Strumento> findBySlug(String slug);
    List<Strumento> findByTipologia(Tipologia tipologia);
}
