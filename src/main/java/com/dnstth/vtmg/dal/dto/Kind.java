package com.dnstth.vtmg.dal.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Denes_Toth
 */
@Entity
public class Kind {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String details;

    @ManyToMany
    private List<Person> people;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
