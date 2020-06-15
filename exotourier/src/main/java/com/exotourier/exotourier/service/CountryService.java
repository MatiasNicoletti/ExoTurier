package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.CountryDao;
import com.exotourier.exotourier.domain.Country;
import com.exotourier.exotourier.exception.country.CountryAlreadyExistException;
import com.exotourier.exotourier.exception.country.CountryNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryDao countryDao;

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

    public Country getById(Integer id) throws CountryNotExistException {
        return countryDao.findById(id).orElseThrow(CountryNotExistException::new);
    }

}
