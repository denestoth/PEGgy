package com.dnstth.vtmg.dal.service;

import com.dnstth.vtmg.dal.dto.Event;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface EventService {
    List<Event> findAll();

    void delete(Event gender);

    void add(Event gender);

    Event findOne(int id);

    void update(Event event);
}
