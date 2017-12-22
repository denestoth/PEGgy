package com.dnstth.vtmg.dal.service;

import com.dnstth.vtmg.dal.dto.Place;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PlaceService {
    List<Place> findAll();

    void delete(Place gender);

    void add(Place gender);

    Place findOne(int id);

    void update(Place place);
}
