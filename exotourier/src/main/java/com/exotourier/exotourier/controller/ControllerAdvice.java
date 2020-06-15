package com.exotourier.exotourier.controller;

import com.exotourier.exotourier.dto.ErrorDto;
import com.exotourier.exotourier.exception.*;
import com.exotourier.exotourier.exception.city.CityAlreadyExistException;
import com.exotourier.exotourier.exception.city.CityNotExistException;
import com.exotourier.exotourier.exception.country.CountryAlreadyExistException;
import com.exotourier.exotourier.exception.country.CountryNotExistException;
import com.exotourier.exotourier.exception.excursion.ExcursionAlreadyExistException;
import com.exotourier.exotourier.exception.excursion.ExcursionNotExistException;
import com.exotourier.exotourier.exception.user.UserEmailAlreadyExistException;
import com.exotourier.exotourier.exception.user.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    /* Cities */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CityAlreadyExistException.class)
    public ErrorDto handleCityAlreadyExistException(CityAlreadyExistException e) {
        return new ErrorDto(1, "City name already exists");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CityNotExistException.class)
    public ErrorDto handleCityNotExistException(CityNotExistException e) {
        return new ErrorDto(2, "City id do not exists");
    }

    /* Countries */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CountryAlreadyExistException.class)
    public ErrorDto handleCountryAlreadyExistException(CountryAlreadyExistException e) {
        return new ErrorDto(3, "Country name already exists");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CountryNotExistException.class)
    public ErrorDto handleCountryNotExistException(CountryNotExistException e) {
        return new ErrorDto(4, "Country id do not exists");
    }

    /* Excursions */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExcursionAlreadyExistException.class)
    public ErrorDto handleExcursionAlreadyExistException(ExcursionAlreadyExistException e) {
        return new ErrorDto(5, "Excursion name already exists");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ExcursionNotExistException.class)
    public ErrorDto handleExcursionNotExistException(ExcursionNotExistException e) {
        return new ErrorDto(6, "Excursion id do not exists");
    }

    /* Purchases */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PurchaseNotExistException.class)
    public ErrorDto handlePurchaseNotExistException(PurchaseNotExistException e) {
        return new ErrorDto(7, "Purchase id di not exists");
    }

    /* Users */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserEmailAlreadyExistException.class)
    public ErrorDto handleUserEmailAlreadyExistException(UserEmailAlreadyExistException e) {
        return new ErrorDto(8, "User email already exists");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotExistException.class)
    public ErrorDto handleUserNotExistException(UserNotExistException e) {
        return new ErrorDto(9, "User id do not exists");
    }



}
