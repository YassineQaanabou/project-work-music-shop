package com.projectwork.shopstrumentimusicali.shop.repository;

import com.projectwork.shopstrumentimusicali.shop.model.Strumento;
import com.projectwork.shopstrumentimusicali.shop.model.Tipologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StrumentoRepository extends JpaRepository<Strumento, Integer> {
    List<Strumento> findByNomeContainingOrTipologiaNomeOrDescrizioneContaining(String keyword1, String keyword2, String keyword3);

    Optional<Strumento> findBySlug(String slug);

    List<Strumento> findByTipologia(Tipologia tipologia);

    // metodo per trovare la lista ordinata di strumenti piu venduti
    @Query("SELECT s, SUM(a.quantity) AS totalQuantity FROM Strumento s LEFT JOIN Acquisto a ON s.id = a.strumento.id AND a.dataAcquisto >= :lastMonth GROUP BY s ORDER BY totalQuantity DESC")
    //@Query("SELECT a.strumento FROM Acquisto a WHERE a.dataAcquisto >= :lastMonth GROUP BY a.strumento ORDER BY SUM(a.quantity) DESC")
    List<Strumento> findTopSellingInLastMonth(@Param("lastMonth") LocalDate lastMonth);

    @Query("SELECT s FROM Strumento s WHERE (LOWER(s.nome) LIKE %:searchString% OR s.prezzo BETWEEN :prezzoMin AND :prezzoMax)")
    List<Strumento> findByCustomSearchQuery(String searchString, Double prezzoMin, Double prezzoMax);

    @Query("SELECT s FROM Strumento s WHERE LOWER(s.nome) LIKE %:searchString%")
    List<Strumento> findByCustomSearchQueryName(String searchString);

    @Query("SELECT s FROM Strumento s WHERE s.tipologia.slug = :tipologiaSlug")
    List<Strumento> findByTipologiaSlug(@Param("tipologiaSlug") String tipologiaSlug);

    @Query("SELECT s FROM Strumento s JOIN Magazzino m ON s.id = m.strumento.id ORDER BY m.quantity ASC")
    List<Strumento> findAllAndOrderAsc();

}

