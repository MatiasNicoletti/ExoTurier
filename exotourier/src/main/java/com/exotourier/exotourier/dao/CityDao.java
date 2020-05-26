package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {

    Optional<City> findByName(String name);
}
