package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.service.PlaceService;
import com.dnstth.vtmg.view.PlaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Controller
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value="/api/place", method= RequestMethod.GET)
    public String getPlacePage(Model model){
        List<PlaceView> kindViews = placeService.getAll();
        model.addAttribute("places", kindViews);
        return "place";
    }

    @RequestMapping(value="/api/place", method= RequestMethod.POST)
    public String addNewPlace(@RequestParam("placeName") String placeName, @RequestParam("placeDetails") String placeDetails, Model model){
        PlaceView placeView = new PlaceView();
        placeView.setName(placeName);
        placeView.setDetails(placeDetails);
        placeService.add(placeView);
        return getPlacePage(model);
    }

    @RequestMapping(value="/api/place/delete", method= RequestMethod.POST)
    public String deletePlace(@RequestParam("id") int id, Model model){
        placeService.delete(id);
        return getPlacePage(model);
    }
}
