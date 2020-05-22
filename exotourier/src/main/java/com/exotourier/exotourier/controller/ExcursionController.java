package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
import com.exotourier.exotourier.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/excursions")
public class ExcursionController {

    private final ExcursionService excursionService;

    @Autowired
    public ExcursionController(final ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @PostMapping("/")
    public void add(@RequestBody Excursion excursion) throws ExcursionAlreadyExistException {
        excursionService.add(excursion);
    }

    @GetMapping("/")
    public List<Excursion> getAll() {
        return excursionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Excursion> getById(@PathVariable final Integer id) {
        return excursionService.getById(id);
    }

}
