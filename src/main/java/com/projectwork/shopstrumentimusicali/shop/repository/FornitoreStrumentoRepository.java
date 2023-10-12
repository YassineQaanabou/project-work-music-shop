package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.FornitoreStrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornitoreStrumentoRepository extends JpaRepository<FornitoreStrumento, Integer> {

    List<FornitoreStrumento> findByStrumentoId(Integer strumentoId);

    List<FornitoreStrumento> findByFornitoreId(Integer fornitoreId);

    FornitoreStrumento findByFornitoreIdAndStrumentoId(Integer fornitoreId, Integer strumentoId);


}
