package com.navent.exercise.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j  //lombok asigna un logger
public class ExceptionAdvicer {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Error handle(HttpServletRequest req, MethodArgumentNotValidException exception) {
        log.info("Exception hija: {}", exception.getMessage());
        return null;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handle(HttpServletRequest req, Exception exception) {
        log.error("Exception padre: {}", exception.getMessage());
        return null;
    }



}
