package com.harilab.clinic.repository;

import com.harilab.clinic.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
//    Participant findByName(String name);

//    Participant findByDevice(String device);
}
