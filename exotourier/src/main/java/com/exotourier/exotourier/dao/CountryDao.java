package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Integer> {

}
