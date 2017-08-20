package com.dnstth.vtmg.service;

import com.dnstth.vtmg.view.EventView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface EventService {

    List<EventView> getAll();

    void add(EventView eventView);

    void delete(int id);
}
