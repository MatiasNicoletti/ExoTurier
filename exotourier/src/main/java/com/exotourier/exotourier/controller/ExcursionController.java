package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Excursion;
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
    public Excursion create(Excursion excursion){
        return excursionService.create(excursion);
    }

    @GetMapping("/{idCountry}")
    public Excursion getById(@PathVariable Integer idCountry){
        return excursionService.getById(idCountry).get();
    }
}
