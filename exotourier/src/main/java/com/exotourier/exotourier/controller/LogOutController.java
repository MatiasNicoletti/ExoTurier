package com.exotourier.exotourier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/logout")
public class LogOutController {

    private final UserController userController;

    @Autowired
    public LogOutController(final UserController userController) {
        this.userController = userController;
    }

    @PostMapping("/")
    public ResponseEntity logout() {
        return ResponseEntity.ok().build();
    }

}
