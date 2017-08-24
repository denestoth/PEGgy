package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.EventRepository;
import com.dnstth.vtmg.dal.dto.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denes_Toth
 */
@Component
public class DefaultEventDao implements EventDao {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public void add(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event findOne(int id) {
        Optional<Event> optional = eventRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

}
