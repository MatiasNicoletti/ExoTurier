package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
import com.exotourier.exotourier.exception.ExcursionNotExistException;
import com.exotourier.exotourier.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/excursions")
public class ExcursionController {

    private final ExcursionService excursionService;

    @Autowired
    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @GetMapping("/")
    public List<Excursion> getAll(){
        return this.excursionService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody @Valid final Excursion excursion) throws ExcursionAlreadyExistException {
        Excursion newExcursion = excursionService.add(excursion);
        return ResponseEntity.created(getLocation(newExcursion)).build();
    }

    @GetMapping("/{idExcursion}")
    public ResponseEntity<Excursion> getById(@PathVariable Integer idExcursion) throws ExcursionNotExistException {
        Excursion excursion = excursionService.getById(idExcursion);
        return ResponseEntity.ok(excursion);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable final Integer id) throws ExcursionNotExistException {

    }

    private URI getLocation(Excursion excursion) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(excursion.getId())
                .toUri();
    }

}
