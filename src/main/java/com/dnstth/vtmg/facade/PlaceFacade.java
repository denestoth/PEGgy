package com.dnstth.vtmg.facade;

import com.dnstth.vtmg.view.PlaceView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PlaceFacade {

    List<PlaceView> getAll();

    PlaceView getOne(int id);

    void add(PlaceView placeView);

    void delete(int id);

    void update(PlaceView placeView);
}
