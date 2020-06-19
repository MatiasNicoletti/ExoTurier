package com.exotourier.exotourier.service;

import com.exotourier.exotourier.dao.CityDao;
import com.exotourier.exotourier.dao.ExcursionDao;
import com.exotourier.exotourier.domain.City;
import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.dto.ExcursionDto;
import com.exotourier.exotourier.exception.city.CityNotExistException;
import com.exotourier.exotourier.exception.excursion.ExcursionNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import com.exotourier.exotourier.exception.excursion.ExcursionAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExcursionService {

    private final ExcursionDao excursionDao;
    private final CityDao cityDao;

    @Autowired
    public ExcursionService(final ExcursionDao excursionDao, final CityDao cityDao) {
        this.excursionDao = excursionDao;
        this.cityDao = cityDao;
    }


    public Excursion add(ExcursionDto newExcursionDto) throws ExcursionAlreadyExistException, CityNotExistException {
        Optional<Excursion> excursion = excursionDao.findByName(newExcursionDto.getName());
        if (excursion.isPresent()) {
            throw new ExcursionAlreadyExistException();
        }

        City city = cityDao.findByName(newExcursionDto.getCity()).orElseThrow(CityNotExistException::new);

        Excursion newExcursion = Excursion.builder()
                                    .name(newExcursionDto.getName())
                                    .description(newExcursionDto.getDescription())
                                    .price(newExcursionDto.getPrice())
                                    .place(newExcursionDto.getPlace())
                                    .city(city)
                                    .gridClass(newExcursionDto.getGridClass())
                                    .imagePathMain(newExcursionDto.getImagePathMain())
                                    .imagePathSecondary(newExcursionDto.getImagePathSecondary())
                                    .isActive(true)
                                    .build();

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
