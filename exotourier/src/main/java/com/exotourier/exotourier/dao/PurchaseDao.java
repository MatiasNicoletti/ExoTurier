package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
}
