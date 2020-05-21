package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.CityDao;
import com.exotourier.exotourier.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
<<<<<<< HEAD
=======
    private CityDao cityDao;

    @Autowired
    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public List<City> getAll(){
        return this.cityDao.findAll();
    }
    public City create(City city){
        return this.cityDao.save(city);
    }

    public Optional<City> getById(Integer id){
        return cityDao.findById(id);
    }
>>>>>>> 551155dc291c46e426018bd12a7c9431b822ba07

}
