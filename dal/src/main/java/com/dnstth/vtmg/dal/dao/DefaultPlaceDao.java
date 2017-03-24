package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.PlaceRepository;
import com.dnstth.vtmg.domain.Place;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public class DefaultPlaceDao implements PlaceDao {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> findAll(){
        return placeRepository.findAll();
    }

    public void delete(Place place){
        placeRepository.delete(place);
    }

    public void add(Place place){
        placeRepository.save(place);
    }
}
