package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.service.EventService;
import com.dnstth.vtmg.service.PersonService;
import com.dnstth.vtmg.service.PlaceService;
import com.dnstth.vtmg.view.EventView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/api/event", method = RequestMethod.GET)
    public String getEventPage(Model model) {
        List<EventView> eventViews = eventService.getAll();
        model.addAttribute("events", eventViews);
        return "event";
    }

    @RequestMapping(value = "/api/event", method = RequestMethod.POST)
    public String addNewEvent(@RequestParam("eventDescription") String eventDescription,
                              @RequestParam("eventDate") Date eventDate,
                              @RequestParam("eventDetails") String eventDetails,
                              @RequestParam("placeViewId") Integer placeViewID,
                              @RequestParam("participandViewIds") List<Integer> participantViewIds,
                              Model model) {
        EventView eventView = new EventView();
        eventView.setDescription(eventDescription);
        eventView.setDate(eventDate);
        eventView.setDetails(eventDetails);
        eventView.setPlace(placeService.getAll().stream().filter(pv -> pv.getId() == placeViewID).findFirst().orElse(null));
        eventView.setParticipans(personService.getAll().stream().filter(personView -> participantViewIds.contains(personView.getId())).collect(Collectors.toList()));
        eventService.add(eventView);
        return getEventPage(model);
    }

    @RequestMapping(value = "/api/event/delete", method = RequestMethod.DELETE)
    public String deleteEvent(@RequestParam("id") int id, Model model) {
        eventService.delete(id);
        return getEventPage(model);
    }
}
