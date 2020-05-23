package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.ExcursionDao;
import com.exotourier.exotourier.domain.Excursion;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
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
=======
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

>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff
}
