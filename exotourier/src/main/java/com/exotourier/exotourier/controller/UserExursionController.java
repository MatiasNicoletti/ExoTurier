package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.UserExcursion;
import com.exotourier.exotourier.service.UserExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserExursionController {

    private UserExcursionService userExcursionService;

    @Autowired
    public UserExursionController(UserExcursionService userExcursionService) {
        this.userExcursionService = userExcursionService;
    }

    @GetMapping("/")
    public List<UserExcursion> getAll(){
        return this.userExcursionService.getAll();
    }

    @PostMapping("/")
    public UserExcursion create(@RequestBody UserExcursion userExcursion){
        return this.userExcursionService.create(userExcursion);
    }

    @GetMapping("/{idUser}")
    public UserExcursion getByID(@PathVariable Integer idUser){
        UserExcursion userExcursion = null;
        userExcursion = this.userExcursionService.getById(idUser).get();
        return userExcursion;
    }


    //todo agregar optional y excepciones
}
