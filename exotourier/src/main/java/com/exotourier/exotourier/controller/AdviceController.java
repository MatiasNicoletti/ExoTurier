package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.dto.ErrorResponseDTO;
import com.exotourier.exotourier.exception.user.UserInvalidLoginException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UserInvalidLoginException.class)
    public ErrorResponseDTO handleLoginException(UserInvalidLoginException exc) {
        return new ErrorResponseDTO(1, "Either entered the wrong email or password");
    }
}
