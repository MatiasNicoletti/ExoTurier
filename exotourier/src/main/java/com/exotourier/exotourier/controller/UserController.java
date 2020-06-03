package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.exception.UserEmailAlreadyExistException;
import com.exotourier.exotourier.exception.UserNotExistException;
import com.exotourier.exotourier.exception.UserNotFoundException;
import com.exotourier.exotourier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = this.userService.getAll();
        return (users.size() > 0) ? ResponseEntity.ok(users) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody @Valid User user) throws UserEmailAlreadyExistException {
        User newUser = userService.create(user);
        return ResponseEntity.created(getLocation(newUser)).build();
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getByID(@PathVariable Integer idUser) throws UserNotFoundException {
        User user = userService.getById(idUser);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable final Integer id,
                                     @RequestBody @Valid final User updatedUser) throws UserNotExistException {
        User user = userService.updateById(id, updatedUser);
        return (user != null) ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    private URI getLocation(User user) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
    }

}
