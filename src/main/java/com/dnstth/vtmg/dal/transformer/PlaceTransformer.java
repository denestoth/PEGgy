package com.dnstth.vtmg.dal.transformer;

import com.dnstth.vtmg.dal.dto.Place;
import com.dnstth.vtmg.view.PlaceView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Component
public class PlaceTransformer implements Transformer<Place, PlaceView> {

    @Override
    public Place viewToDto(PlaceView placeView) {
        Place place = new Place();
        place.setId(placeView.getId());
        place.setName(placeView.getName());
        place.setDetails(placeView.getDetails());
        return place;
    }

    @Override
    public List<Place> viewsToDtos(List<PlaceView> placeViews) {
        return placeViews != null ? placeViews.stream().map(pv -> viewToDto(pv)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public PlaceView dtoToView(Place place) {
        PlaceView placeView = new PlaceView();
        placeView.setId(place.getId());
        placeView.setName(place.getName());
        placeView.setDetails(place.getDetails());
        return placeView;
    }

    @Override
    public List<PlaceView> dtosToViews(List<Place> places) {
        return places != null ? places.stream().map(p -> dtoToView(p)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
