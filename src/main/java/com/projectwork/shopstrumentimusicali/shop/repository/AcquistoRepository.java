package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Acquisto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AcquistoRepository extends JpaRepository<Acquisto, Integer> {

    List<Acquisto> findByDataAcquistoBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT a.strumento.nome, SUM(a.quantity) " +
            "FROM Acquisto a " +
            "GROUP BY a.strumento.nome")
    List<Object[]> findVenditeTotaliPerProdotto();


    @Query("SELECT a.strumento.tipologia, SUM(a.quantity) " +
            "FROM Acquisto a " +
            "GROUP BY a.strumento.tipologia")
    List<Object[]> findAcquistiPerTipologia();


    @Query("SELECT a.strumento.nome, SUM(a.quantity) " +
            "FROM Acquisto a " +
            "WHERE a.dataAcquisto >= :startDate AND a.dataAcquisto <= :endDate " +
            "GROUP BY a.strumento.nome")
    List<Object[]> findVenditeTotaliPerProdottoLastMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT a.strumento.tipologia, SUM(a.quantity) " +
            "FROM Acquisto a " +
            "WHERE a.dataAcquisto >= :startDate AND a.dataAcquisto <= :endDate " +
            "GROUP BY a.strumento.tipologia")
    List<Object[]> findAcquistiPerTipologiaLastMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


}
