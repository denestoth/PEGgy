package com.dnstth.vtmg.dal.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dnstth.vtmg.dal.dto.Place;
import com.dnstth.vtmg.view.PlaceView;
import org.springframework.stereotype.Component;

/**
 * Created by Denes_Toth
 */
@Component
public class PlaceTransformer implements Transformer<Place, PlaceView> {

    @Override
    public Place viewToDto(PlaceView placeView) {
        return Place.builder()
                   .id(placeView.getId())
                   .name(placeView.getName())
                   .details(placeView.getDetails())
                   .build();
    }

    @Override
    public List<Place> viewsToDtos(List<PlaceView> placeViews) {
        return placeViews != null ? placeViews.stream().map(pv -> viewToDto(pv)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public PlaceView dtoToView(Place place) {
        return PlaceView.builder()
                   .id(place.getId())
                   .name(place.getName())
                   .details(place.getDetails())
                   .build();
    }

    @Override
    public List<PlaceView> dtosToViews(List<Place> places) {
        return places != null ? places.stream().map(p -> dtoToView(p)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
