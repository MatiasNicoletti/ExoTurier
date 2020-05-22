package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.ExcursionDao;
import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcursionService {

    private final ExcursionDao excursionDao;

    @Autowired
    public ExcursionService(final ExcursionDao excursionDao) {
        this.excursionDao = excursionDao;
    }


    public void add(Excursion newExcursion) throws ExcursionAlreadyExistException {
        Optional<Excursion> excursion = excursionDao.findByName(newExcursion.getName());
        if (excursion.isPresent()) {
            throw new ExcursionAlreadyExistException();
        }
        excursionDao.save(newExcursion);
    }

    public List<Excursion> getAll() {
        return excursionDao.findAll();
    }

    public Optional<Excursion> getById(Integer id) {
        return excursionDao.findById(id);
    }

}
