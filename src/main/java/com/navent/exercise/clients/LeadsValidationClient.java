package com.navent.exercise.clients;

import com.navent.exercise.clients.model.EmailValidation;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "LeadsValidationClient", url = "${configuration.leads.validation.url}")
@Headers("Content-Type: application/json")
public interface LeadsValidationClient {

    @GetMapping(value = "/email/{email}")
    EmailValidation isEmailValid(@PathVariable("email") String email);


}
