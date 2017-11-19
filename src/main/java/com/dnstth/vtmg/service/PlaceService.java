package com.dnstth.vtmg.service;

import com.dnstth.vtmg.view.PlaceView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PlaceService {

    List<PlaceView> getAll();

    PlaceView getOne(int id);

    void add(PlaceView placeView);

    void delete(int id);

    void update(PlaceView placeView);
}
