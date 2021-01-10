package com.harilab.clinic.controller;

import com.harilab.clinic.model.Clinician;
import com.harilab.clinic.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService service;

    @CrossOrigin
    @PostMapping("/login")
    public boolean clinicianLogin(@RequestBody Clinician clinician){
        return service.clinicianLogin(clinician);
    }
}
