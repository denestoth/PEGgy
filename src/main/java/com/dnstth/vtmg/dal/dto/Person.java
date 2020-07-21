package com.dnstth.vtmg.dal.dto;

import lombok.Builder;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Entity
public class Person {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Date birthDate;

    @Column
    private Date deathDate;

    @Column
    private String details;

    @ManyToOne
    @JoinColumn(name = "kind_id")
    private Kind kind;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "EventParticipants",
            joinColumns = { @JoinColumn(name="personid") },
            inverseJoinColumns = { @JoinColumn(name="eventid")}
    )
    private List<Event> events;
}
