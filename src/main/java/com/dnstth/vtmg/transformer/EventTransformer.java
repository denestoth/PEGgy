package com.dnstth.vtmg.transformer;

import com.dnstth.vtmg.dal.dto.Event;
import com.dnstth.vtmg.view.EventView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Component
public class EventTransformer implements Transformer<Event, EventView> {

    @Autowired
    private PlaceTransformer placeTransformer;

    @Autowired
    private PersonTransformer personTransformer;

    @Override
    public Event viewToDto(EventView eventView) {
        Event event = new Event();
        event.setId(eventView.getId());
        event.setDate(eventView.getDate());
        event.setDescription(eventView.getDescription());
        event.setDetails(eventView.getDetails());
        event.setParticipants(personTransformer.viewsToDtos(eventView.getParticipants()));
        event.setPlace(placeTransformer.viewToDto(eventView.getPlace()));
        return event;
    }

    @Override
    public List<Event> viewsToDtos(List<EventView> eventViews) {
        return eventViews != null ? eventViews.stream().map(ev -> viewToDto(ev)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public EventView dtoToView(Event event) {
        EventView eventView = new EventView();
        eventView.setId(event.getId());
        eventView.setDate(event.getDate());
        eventView.setDescription(event.getDescription());
        eventView.setDetails(event.getDetails());
        eventView.setParticipants(personTransformer.dtosToViews(event.getParticipants()));
        eventView.setPlace(placeTransformer.dtoToView(event.getPlace()));
        return eventView;
    }

    @Override
    public List<EventView> dtosToViews(List<Event> events) {
        return events != null ? events.stream().map(e -> dtoToView(e)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
