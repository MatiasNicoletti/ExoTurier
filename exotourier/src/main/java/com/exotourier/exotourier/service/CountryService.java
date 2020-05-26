package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.CountryDao;
import com.exotourier.exotourier.domain.Country;
import com.exotourier.exotourier.exception.CountryAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private CountryDao countryDao;

    @Autowired
    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public List<Country> getAll(){
        return this.countryDao.findAll();
    }

    public Country create(Country country) throws CountryAlreadyExistException {
        Optional<Country> c = countryDao.findByName(country.getName());
        if (c.isPresent()) {
            throw new CountryAlreadyExistException();
        }
        return this.countryDao.save(country);
    }

    public Optional<Country> getById(Integer id){
        return countryDao.findById(id);
    }

}
