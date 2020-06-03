package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.City;
import com.exotourier.exotourier.exception.CityAlreadyExistException;
import com.exotourier.exotourier.exception.CityNotExistException;
import com.exotourier.exotourier.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public ResponseEntity<List<City>> getAll(){
        List<City> cities = cityService.getAll();
        return (cities.size() > 0) ? ResponseEntity.ok(cities) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody @Valid City city) throws CityAlreadyExistException {
        City newCity = cityService.create(city);
        return ResponseEntity.created(getLocation(newCity)).build();
    }

    @GetMapping("/{idCity}")
    public ResponseEntity<City> getById(@PathVariable Integer idCity) throws CityNotExistException {
        City city = cityService.getById(idCity);
        return ResponseEntity.ok(city);
    }

    private URI getLocation(City city) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(city.getId())
                .toUri();
    }

}
