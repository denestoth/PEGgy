package com.dnstth.vtmg.view;

import java.util.Date;
import java.util.List;

/**
 * Created by Denes_Toth
 */
public class PersonView {

    private int id;

    private String name;

    private Date birthDate;

    private Date deathDate;

    private String details;

    private KindView kind;

    private GenderView gender;

    private List<EventView> events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public KindView getKind() {
        return kind;
    }

    public void setKind(KindView kind) {
        this.kind = kind;
    }

    public GenderView getGender() {
        return gender;
    }

    public void setGender(GenderView gender) {
        this.gender = gender;
    }

    public List<EventView> getEvents() {
        return events;
    }

    public void setEvents(List<EventView> events) {
        this.events = events;
    }
}
