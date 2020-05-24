package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityDao extends JpaRepository<City,Integer> {

    Optional<City> findByName(String name);
}
