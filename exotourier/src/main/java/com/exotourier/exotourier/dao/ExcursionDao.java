package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExcursionDao extends JpaRepository<Excursion, Integer> {
    Optional<Excursion> findByName(String name);
}
