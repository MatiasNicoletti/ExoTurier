package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.Excursion;
<<<<<<< HEAD
=======
import com.exotourier.exotourier.exception.ExcursionAlreadyExistException;
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff
import com.exotourier.exotourier.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

@RestController
@RequestMapping("/excursions")
public class ExcursionController {
<<<<<<< HEAD
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
=======

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

>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff
}
