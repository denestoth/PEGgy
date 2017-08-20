package com.dnstth.vtmg.service;

import com.dnstth.vtmg.dal.dao.EventDao;
import com.dnstth.vtmg.transformer.EventTransformer;
import com.dnstth.vtmg.view.EventView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultEventService implements EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private EventTransformer eventTransformer;

    @Override
    public List<EventView> getAll() {
        return eventTransformer.dtosToViews(eventDao.findAll());
    }

    @Override
    public void add(EventView eventView) {
        eventDao.add(eventTransformer.viewToDto(eventView));
    }

    @Override
    public void delete(int id) {
        eventDao.delete(eventDao.findOne(id));
    }
}
