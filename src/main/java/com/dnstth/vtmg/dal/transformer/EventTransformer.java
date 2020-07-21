package com.dnstth.vtmg.dal.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dnstth.vtmg.dal.dto.Event;
import com.dnstth.vtmg.view.EventView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return Event.builder()
                   .id(eventView.getId())
                   .date(eventView.getDate())
                   .description(eventView.getDescription())
                   .details(eventView.getDetails())
                   .participants(personTransformer.viewsToDtos(eventView.getParticipants()))
                   .place(placeTransformer.viewToDto(eventView.getPlace()))
                   .build();
    }

    @Override
    public List<Event> viewsToDtos(List<EventView> eventViews) {
        return eventViews != null ? eventViews.stream().map(ev -> viewToDto(ev)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public EventView dtoToView(Event event) {
        return EventView.builder()
                   .id(event.getId())
                   .date(event.getDate())
                   .description(event.getDescription())
                   .details(event.getDetails())
                   .participants(personTransformer.dtosToViews(event.getParticipants()))
                   .place(placeTransformer.dtoToView(event.getPlace()))
                   .build();
    }

    @Override
    public List<EventView> dtosToViews(List<Event> events) {
        return events != null ? events.stream().map(e -> dtoToView(e)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
