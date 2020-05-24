package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryDao extends JpaRepository<Country, Integer> {

    Optional<Country> findByName(String name);

}
