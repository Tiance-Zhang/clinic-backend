package com.harilab.clinic.repository;

import com.harilab.clinic.model.Clinician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClinicianRepository extends JpaRepository<Clinician, Integer> {

    @Query(value = "select * from clinician c where c.username= ?1 and c.password = ?2", nativeQuery = true)
    Clinician findClinicianByNameAndPassword(String username, String password);
}


