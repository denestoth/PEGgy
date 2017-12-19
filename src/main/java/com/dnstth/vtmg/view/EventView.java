package com.dnstth.vtmg.view;

import java.util.Date;
import java.util.List;

/**
 * Created by Denes_Toth
 */
public class EventView {

    private int id;

    private String description;

    private Date date;

    private String details;

    private PlaceView place;

    private List<PersonView> participants;

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

    public PlaceView getPlace() {
        return place;
    }

    public void setPlace(PlaceView place) {
        this.place = place;
    }

    public List<PersonView> getParticipants() {
        return participants;
    }

    public void setParticipants(List<PersonView> participants) {
        this.participants = participants;
    }
}
