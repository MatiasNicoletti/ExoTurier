package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {

}
