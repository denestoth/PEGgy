package com.dnstth.vtmg.transformer;

import com.dnstth.vtmg.dal.dto.Place;
import com.dnstth.vtmg.view.PlaceView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        List<Place> places = new ArrayList<Place>();

        for (PlaceView placeView: placeViews) {
            places.add(viewToDto(placeView));
        }

        return places;
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
        List<PlaceView> placeViews = new ArrayList<PlaceView>();

        for (Place place: places) {
            placeViews.add(dtoToView(place));
        }

        return placeViews;
    }
}
