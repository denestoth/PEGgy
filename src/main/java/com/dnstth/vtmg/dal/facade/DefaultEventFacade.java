package com.dnstth.vtmg.dal.facade;

import com.dnstth.vtmg.dal.service.EventService;
import com.dnstth.vtmg.dal.transformer.EventTransformer;
import com.dnstth.vtmg.view.EventView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultEventFacade implements EventFacade {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventTransformer eventTransformer;

    @Override
    public List<EventView> getAll() {
        return eventTransformer.dtosToViews(eventService.findAll());
    }

    @Override
    public EventView getOne(int id) {
        return eventTransformer.dtoToView(eventService.findOne(id));
    }

    @Override
    public void add(EventView eventView) {
        eventService.add(eventTransformer.viewToDto(eventView));
    }

    @Override
    public void delete(int id) {
        eventService.delete(eventService.findOne(id));
    }

    @Override
    public void update(EventView eventView) {
        eventService.update(eventTransformer.viewToDto(eventView));
    }
}
