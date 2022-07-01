package com.navent.exercise.rest;

import com.navent.exercise.clients.model.EmailValidation;
import com.navent.exercise.clients.LeadsValidationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validation")
public class ValidationController {

    @Autowired
    private LeadsValidationClient client;

    @GetMapping("email")
    public EmailValidation validate() {
        return client.isEmailValid("sclinis");
    }
}
