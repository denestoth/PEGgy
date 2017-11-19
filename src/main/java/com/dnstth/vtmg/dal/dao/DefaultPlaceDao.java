package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.PlaceRepository;

import com.dnstth.vtmg.dal.dto.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denes_Toth
 */
@Component
public class DefaultPlaceDao implements PlaceDao {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public void delete(Place place) {
        placeRepository.delete(place);
    }

    @Override
    public void add(Place place) {
        placeRepository.save(place);
    }

    @Override
    public Place findOne(int id) {
        Optional<Place> optional = placeRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public void update(Place place) {
        placeRepository.saveAndFlush(place);
    }
}
