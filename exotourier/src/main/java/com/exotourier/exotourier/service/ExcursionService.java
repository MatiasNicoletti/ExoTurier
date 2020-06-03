package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.ExcursionDao;
import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.exception.ExcursionNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
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


    public Excursion add(Excursion newExcursion) throws ExcursionAlreadyExistException {
        Optional<Excursion> excursion = excursionDao.findByName(newExcursion.getName());
        if (excursion.isPresent()) {
            throw new ExcursionAlreadyExistException();
        }
        return excursionDao.save(newExcursion);
    }

    public List<Excursion> getAll() {
        return excursionDao.findAll();
    }

    public Excursion getById(Integer id) throws ExcursionNotExistException {
        return excursionDao.findById(id).orElseThrow(ExcursionNotExistException::new);
    }


    public Excursion updateById(Integer id, Excursion updatedExcursion) throws ExcursionNotExistException {
        Optional<Excursion> excursion = excursionDao.findById(id);
        if (!excursion.isPresent()) {
            throw new ExcursionNotExistException();
        }
        updatedExcursion.setId(id);
        return excursionDao.save(excursion.get());
    }

}
