package com.dnstth.vtmg.service;

import com.dnstth.vtmg.dal.dao.PlaceDao;
import com.dnstth.vtmg.transformer.PlaceTransformer;
import com.dnstth.vtmg.view.PlaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultPlaceService implements PlaceService {

    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private PlaceTransformer placeTransformer;

    @Override
    public List<PlaceView> getAll() {
        return placeTransformer.dtosToViews(placeDao.findAll());
    }

    @Override
    public void add(PlaceView genderView) {
        placeDao.add(placeTransformer.viewToDto(genderView));
    }

    @Override
    public void delete(int id) {
        placeDao.delete(placeDao.findOne(id));
    }
}
