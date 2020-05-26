package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.UserExcursion;
import com.exotourier.exotourier.service.UserExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usersExcursions")
public class UserExcursionController {

    private UserExcursionService userExcursionService;

    @Autowired
    public UserExcursionController(UserExcursionService userExcursionService) {
        this.userExcursionService = userExcursionService;
    }

    @GetMapping("/")
    public List<UserExcursion> getAll(){
        System.out.println(this.userExcursionService.getAll());
        return this.userExcursionService.getAll();
    }

    @PostMapping("/")
    public UserExcursion create(@RequestBody UserExcursion userExcursion){
        return this.userExcursionService.create(userExcursion);
    }

    @GetMapping("/{idUserExcursion}")
    public UserExcursion getByID(@PathVariable Integer idUserExcursion){
        UserExcursion userExcursion = null;
        userExcursion = this.userExcursionService.getById(idUserExcursion).get();
        return userExcursion;
    }

    //todo agregar optional y excepciones
}
