package com.harilab.clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PARTICIPANT")
public class Participant {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String username;
    @NotNull
    private String device_id;
    private Timestamp last_record_time = new Timestamp(150000000000L);
    @NotNull
    private int alert_days;
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY, mappedBy = "participant")
    @JsonIgnore
    private List<Record> records;
}
