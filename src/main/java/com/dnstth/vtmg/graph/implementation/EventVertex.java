package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.dal.dto.Event;

/**
 * @author Denes_Toth
 */
public class EventVertex extends DefaultVertex {

    Event event;

    public EventVertex(Event event) {
        this.event = event;
    }

    public Event getEventView() {
        return event;
    }

    public void setEventView(Event eventView) {
        this.event = eventView;
    }

    @Override
    public String getCaption() {
        return this.event.getDescription();
    }

    @Override
    public int hashCode() {
        return event.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return event.equals(obj);
    }
}
