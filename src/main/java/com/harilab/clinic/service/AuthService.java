package com.harilab.clinic.service;

import com.harilab.clinic.model.Clinician;
import com.harilab.clinic.repository.ClinicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ClinicianRepository repository;

    public boolean clinicianLogin(Clinician clinician) {
        Clinician other = repository.findClinicianByNameAndPassword(clinician.getUsername(), clinician.getPassword());
        return other != null;
    }
}
