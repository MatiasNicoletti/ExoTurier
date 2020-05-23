package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.UserNotFoundException;
import com.exotourier.exotourier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAll(){
        return this.userService.getAll();
    }

    @PostMapping("/")
    public User create(@RequestBody User user){
        return this.userService.create(user);
    }

    @GetMapping("/{idUser}")
    public User getByID(@PathVariable Integer idUser){
        User user = null;
        try{
            user = this.userService.getById(idUser);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

}
