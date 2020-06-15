package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.domain.User;
import com.exotourier.exotourier.dto.UserLoginDto;
import com.exotourier.exotourier.exception.user.UserInvalidLoginException;
import com.exotourier.exotourier.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.ValidationException;
import java.util.Optional;

public class LoginController {

    private final UserController userController;
    private final SessionManager sessionManager;

    @Autowired
    public LoginController(final UserController userController,
                           final SessionManager sessionManager) {
        this.userController = userController;
        this.sessionManager = sessionManager;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody final UserLoginDto userLoginDto) throws UserInvalidLoginException, ValidationException{

        ResponseEntity response;
        User u = Optional.ofNullable(userController.login(userLoginDto.getUsername(), userLoginDto.getPassword())).orElseThrow(UserInvalidLoginException::new);
        String token = sessionManager.createSession(u);
        response = ResponseEntity.ok().headers(createHeaders(token)).build();
        return response;
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") final String token) {
        sessionManager.removeSession(token);
        return ResponseEntity.ok().build();
    }

    private HttpHeaders createHeaders(String token) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return responseHeaders;
    }
}

