package com.dnstth.vtmg.service;

import com.dnstth.vtmg.view.PlaceView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PlaceService {

    List<PlaceView> getAll();

    void add(PlaceView genderView);

    void delete(int id);
}
