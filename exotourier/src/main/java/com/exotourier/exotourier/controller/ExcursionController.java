package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Excursion;
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
import com.exotourier.exotourier.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/excursions")
public class ExcursionController {

    private ExcursionService excursionService;

    @Autowired
    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }

    @GetMapping("/")
    public List<Excursion> getAll(){
        return this.excursionService.getAll();
    }

    @PostMapping("/")
    public Excursion create(@RequestBody final Excursion excursion) throws ExcursionAlreadyExistException {
        return excursionService.add(excursion);
    }

    @GetMapping("/{idExcursion}")
    public Excursion getById(@PathVariable Integer idExcursion){
        System.out.println(excursionService.getById(idExcursion).get());
        return excursionService.getById(idExcursion).get();
    }
}
