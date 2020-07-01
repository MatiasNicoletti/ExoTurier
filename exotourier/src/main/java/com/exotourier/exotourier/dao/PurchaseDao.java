package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.projection.MostPurchased;
import com.exotourier.exotourier.projection.PurchaseDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

    @Query(
            value = "SELECT p.id_excursion, count(p.id_excursion) as 'numberOfPurchases' FROM purchases p " +
                    "GROUP BY id_excursion " +
                    "ORDER BY count(p.id_excursion) DESC "+
                    "LIMIT 1",
            nativeQuery = true
    )
    MostPurchased findMostPurchased();


    @Query(
            value = "SELECT p.* FROM purchases p " +
                    "WHERE p.id_user = ?1",
            nativeQuery = true
    )
    Optional<List<Purchase>> getUserExcursions(Integer userId);

    @Query(
            value = "SELECT count(p.id) AS number, p.purchase_date AS date FROM purchases p WHERE p.purchase_date BETWEEN ?1 AND ?2 GROUP BY p.id",
            nativeQuery = true
    )
    List<PurchaseDate> getAllBetweenDates(Date from, Date to);
}
