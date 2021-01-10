package com.harilab.clinic.controller;

import com.harilab.clinic.model.Clinician;
import com.harilab.clinic.service.ClinicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  ClinicianController {

    @Autowired
    private ClinicianService service;

    @CrossOrigin
    @PostMapping("/clinicians")
    public Clinician addClinician(@RequestBody Clinician clinician){
        return service.saveClinician(clinician);
    }

    @CrossOrigin
    @GetMapping("/clinicians")
    public List<Clinician> getClinicians(){
        return service.getClinicians();
    }

    @CrossOrigin
    @GetMapping("/clinicians/{id}")
    public Clinician getClinicianById(@PathVariable int id){
        return service.getClinicianById(id);
    }

//    @CrossOrigin
//    @GetMapping("/Clinicians/{name}")
//    public Clinician getClinicianByName(@PathVariable String name){
//        return service.getClinicianByName(name);
//    }

    @CrossOrigin
    @PatchMapping("/clinicians")
    public Clinician updateClinician(@RequestBody Clinician clinician){
        return service.updateClinician(clinician);
    }

    @CrossOrigin
    @DeleteMapping("/clinicians/{id}")
    public String deleteClinician(@PathVariable int id){
        return service.deleteClinicianById(id);
    }


}
