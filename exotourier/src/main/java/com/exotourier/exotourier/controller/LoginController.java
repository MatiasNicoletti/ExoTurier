package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.dto.UserLoginDto;
import com.exotourier.exotourier.exception.user.UserInvalidLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserController userController;

    @Autowired
    public LoginController(final UserController userController) {
        this.userController = userController;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody final UserLoginDto userLoginDto) throws UserInvalidLoginException, ValidationException{

        ResponseEntity response;
        User u = Optional.ofNullable(userController.login(userLoginDto.getEmail(), userLoginDto.getPassword())).orElseThrow(UserInvalidLoginException::new);
        response = ResponseEntity.ok().body(u);
        return response;
    }

    @PostMapping("/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok().build();
    }

    private HttpHeaders createHeaders(String token) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return responseHeaders;
    }
}

