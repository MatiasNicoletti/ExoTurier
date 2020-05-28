package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.City;
import com.exotourier.exotourier.exception.CityAlreadyExistException;
import com.exotourier.exotourier.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<City> getAll(){
        return cityService.getAll();
    }

    @PostMapping("/")
    public City create(@RequestBody @Valid City city) throws CityAlreadyExistException {
        return cityService.create(city);
    }

    @GetMapping("/{idCity}")
    public City getById(@PathVariable Integer idCity){
        return cityService.getById(idCity).get();
    }
}
