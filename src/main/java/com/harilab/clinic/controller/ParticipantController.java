package com.harilab.clinic.controller;

import com.harilab.clinic.model.Participant;
import com.harilab.clinic.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService service;

    @CrossOrigin
    @PostMapping("/participants")
    public Participant addParticipant(@RequestBody Participant participant){
        return service.saveParticipant(participant);
    }


    @GetMapping("/participants")
    @CrossOrigin
    public List<Participant> getParticipants(){
        return service.getParticipants();
    }

    @CrossOrigin
    @GetMapping("/participants/alert")
    public List<Participant> getParticipantsInAlertOrder(){
        return service.getParticipantInAlertOrder();
    }

    @CrossOrigin
    @GetMapping("/participants/{id}")
    public Participant getParticipantById(@PathVariable int id){
        return service.getParticipantById(id);
    }

//    @CrossOrigin
//    @GetMapping("/participants/{name}")
//    public Participant getParticipantByName(@PathVariable String name){
//        return service.getParticipantByName(name);
//    }

//    @CrossOrigin
//    @GetMapping("/participants/{device}")
//    public Participant getParticipantByDevice(@PathVariable String device){
//        return service.getParticipantByDevice(device);
//    }

    @CrossOrigin
    @PatchMapping("/participants")
    public Participant updateParticipant(@RequestBody Participant participant){
        return service.updateParticipant(participant);
    }

    @CrossOrigin
    @DeleteMapping("/participants/{id}")
    public String deleteParticipant(@PathVariable int id){
        return service.deleteParticipantById(id);
    }


}
