package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcquistoRepository extends JpaRepository<Acquisto, Integer> {
    @Query("SELECT a.strumento.nome, SUM(a.quantity) " +
            "FROM Acquisto a " +
            "GROUP BY a.strumento.nome")
    List<Object[]> findVenditeTotaliPerProdotto();

    @Query("SELECT a.strumento.nome AS nomeProdotto, SUM(a.quantity) AS quantita, a.dataAcquisto AS data " +
            "FROM Acquisto a " +
            "GROUP BY a.strumento.nome, a.dataAcquisto " +
            "ORDER BY a.strumento.nome, a.dataAcquisto")
    List<Object[]> findVenditeGiornalierePerProdotto();

}
