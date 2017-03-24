package com.dnstth.vtmg.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Denes_Toth
 */
@Entity
public class Event {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String description;

    @Column
    private Date date;

    @Column
    private String details;

    @ManyToOne
    private Place place;

    @ManyToMany
    private List<Person> participans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<Person> getParticipans() {
        return participans;
    }

    public void setParticipans(List<Person> participans) {
        this.participans = participans;
    }
}
