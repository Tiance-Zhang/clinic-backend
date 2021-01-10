package com.harilab.clinic.service;

import com.harilab.clinic.model.Clinician;
import com.harilab.clinic.repository.ClinicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicianService {
    @Autowired
    private ClinicianRepository repository;

    // create clinician
    public Clinician saveClinician(Clinician clinician){
        return repository.save(clinician);
    }
    public List<Clinician> saveClinicians(List<Clinician> clinicians){
        return repository.saveAll(clinicians);
    }

    // get clinician
    public List<Clinician> getClinicians(){
        return repository.findAll();
    }
    public Clinician getClinicianById(int id){
        return repository.findById(id).orElse(null);
    }
//    public Clinician getClinicianByName(String name){
//        return repository.findByName(name);
//    }

    // delete clinician
    public String deleteClinicianById(int id){
        repository.deleteById(id);
        return "Clinician removed !!" + id;
    }

    // update clinician
    public Clinician updateClinician(Clinician clinician){
        Clinician existingClinician = repository.findById(clinician.getId()).orElse(null);
        existingClinician.setUsername(clinician.getUsername());
        existingClinician.setPassword(clinician.getPassword());
        return repository.save(existingClinician);
    }

}
