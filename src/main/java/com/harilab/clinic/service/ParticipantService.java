package com.harilab.clinic.service;

import com.harilab.clinic.model.Participant;
import com.harilab.clinic.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository repository;

    // create participant
    public Participant saveParticipant(Participant participant) {
        return repository.save(participant);
    }

    public List<Participant> saveParticipants(List<Participant> participants) {
        return repository.saveAll(participants);
    }

    // get participant
    public List<Participant> getParticipants() {
        return repository.findAll();
    }

    public List<Participant> getParticipantInAlertOrder(){
        List<Participant> result = getParticipants();
        // update
        for(Participant p: result){
            participantAlertUpdateHelper(p);
        }
        result.sort(new CompareByAlertDays());
        return result;
    }

    private void participantAlertUpdateHelper(Participant participant) {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastRecordDate = Instant.ofEpochMilli(participant.getLast_record_time().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        int days = Period.between(lastRecordDate, currentDate).getDays();
        participant.setAlert_days(days);
        repository.save(participant);
    }

    public Participant getParticipantById(int id) {
        return repository.findById(id).orElse(null);
    }
//    public Participant getParticipantByName(String name){
//        return repository.findByName(name);
//    }
//    public Participant getParticipantByDevice(String device){
//        return repository.findByDevice(device);
//    }
//    public Participant getParticipantsByClinicianId(int cid){ return repository.findByClinicianId(cid); }

    // delete participant
    public String deleteParticipantById(int id) {
        repository.deleteById(id);
        return "Participant removed !!" + id;
    }

    // update participant
    public Participant updateParticipant(Participant participant) {
        Participant existingParticipant = repository.findById(participant.getId()).orElse(null);
        existingParticipant.setUsername(participant.getUsername());
        existingParticipant.setDevice_id(participant.getDevice_id());
        return repository.save(existingParticipant);
    }

    /**
     * Comparator class used to sort record in reversed time order.
     */
    private class CompareByAlertDays implements Comparator<Participant> {
        public int compare(Participant one, Participant two) {
            return Integer.compare (two.getAlert_days(), one.getAlert_days());
        }
    }
}
