package com.dnstth.vtmg.dal.facade;

import com.dnstth.vtmg.dal.service.PlaceService;
import com.dnstth.vtmg.dal.transformer.PlaceTransformer;
import com.dnstth.vtmg.view.PlaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultPlaceFacade implements PlaceFacade {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceTransformer placeTransformer;

    @Override
    public List<PlaceView> getAll() {
        return placeTransformer.dtosToViews(placeService.findAll());
    }

    @Override
    public PlaceView getOne(int id) {
        return placeTransformer.dtoToView(placeService.findOne(id));
    }

    @Override
    public void add(PlaceView placeView) {
        placeService.add(placeTransformer.viewToDto(placeView));
    }

    @Override
    public void delete(int id) {
        placeService.delete(placeService.findOne(id));
    }

    @Override
    public void update(PlaceView placeView) {
        placeService.update(placeTransformer.viewToDto(placeView));
    }
}
