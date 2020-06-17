package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Purchase;
import com.exotourier.exotourier.projection.MostPurchased;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
            value = "SELECT p.* FROM purchases  " +
                    "WHERE p.id_user = ?1",
            nativeQuery = true
    )
    Optional<List<Purchase>> getUserExcursions(Integer userId);
}
