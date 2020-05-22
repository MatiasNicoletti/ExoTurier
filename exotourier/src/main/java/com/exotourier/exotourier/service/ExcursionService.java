package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.ExcursionDao;
import com.exotourier.exotourier.domain.Excursion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ExcursionService {

    private ExcursionDao excursionDao;

    @Autowired
    public ExcursionService(ExcursionDao excursionDao) {
        this.excursionDao = excursionDao;
    }

    public List<Excursion> getAll(){
        return this.excursionDao.findAll();
    }
    public Excursion create(Excursion excursion){
        return this.excursionDao.save(excursion);
    }

    public Optional<Excursion> getById(Integer id){
        return excursionDao.findById(id);
    }
}
