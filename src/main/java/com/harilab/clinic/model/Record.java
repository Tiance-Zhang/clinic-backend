package com.harilab.clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RECORD")
public class Record {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String location;
    @NotNull
    private Timestamp time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Participant participant;

}

