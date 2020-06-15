package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Country;
import com.exotourier.exotourier.exception.country.CountryAlreadyExistException;
import com.exotourier.exotourier.exception.country.CountryNotExistException;
import com.exotourier.exotourier.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Country>> getAll(){
        List<Country> countries = countryService.getAll();
        return (countries.size() > 0) ? ResponseEntity.ok(countries) :  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody @Valid Country country) throws CountryAlreadyExistException {
        Country newCountry =  countryService.create(country);
        return ResponseEntity.created(getLocation(newCountry)).build();
    }

    @GetMapping("/{idCountry}")
    public ResponseEntity<Country> getById(@PathVariable Integer idCountry) throws CountryNotExistException {
        Country country = countryService.getById(idCountry);
        return ResponseEntity.ok(country);
    }

    private URI getLocation(Country country) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(country.getId())
                .toUri();
    }

}
