package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.EventRepository;
import com.dnstth.vtmg.domain.Event;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public class DefaultEventDao implements EventDao {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public void delete(Event event){
        eventRepository.delete(event);
    }

    public void add(Event event){
        eventRepository.save(event);
    }

}
