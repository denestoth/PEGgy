package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.dto.Place;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PlaceDao {
    List<Place> findAll();

    void delete(Place gender);

    void add(Place gender);

    Place findOne(int id);

    void update(Place place);
}
