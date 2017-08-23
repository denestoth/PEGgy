package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.dal.dto.Kind;
import com.dnstth.vtmg.service.GenderService;
import com.dnstth.vtmg.service.KindService;
import com.dnstth.vtmg.service.PersonService;
import com.dnstth.vtmg.view.GenderView;
import com.dnstth.vtmg.view.KindView;
import com.dnstth.vtmg.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Controller
public class PersonController {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    @Autowired
    private PersonService personService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private KindService kindService;

    @RequestMapping(value="/api/person", method= RequestMethod.GET)
    public String getPersonPage(Model model) {
        List<PersonView> personViews = personService.getAll();
        model.addAttribute("people", personViews);
        return "person";
    }

    @RequestMapping(value="/api/person", method=RequestMethod.POST)
    public String addNewPerson(@RequestParam("personName") String personName,
                                @RequestParam("personBirthDate") String  personBirthDate,
                                @RequestParam("personDeathDate") String personDeathDate,
                                @RequestParam("personDetails") String personDetails,
                                @RequestParam("personGenderId") int personGenderId,
                               @RequestParam("personKindId") int personKindId,
                                Model model) {
        PersonView personView = new PersonView();
        personView.setName(personName);
        personView.setBirthDate(parseDate(personBirthDate));
        personView.setDeathDate(parseDate(personDeathDate));
        personView.setDetails(personDetails);
        personView.setGender(genderService.getAll().stream().filter(gv -> gv.getId() == personGenderId).findFirst().orElse(null));
        personView.setKind(kindService.getAll().stream().filter(k -> k.getId() == personKindId).findFirst().orElse(null));
        personView.setEvents(Collections.emptyList());
        personService.add(personView);
        return getPersonPage(model);
    }

    @RequestMapping(value="/api/person/delete", method=RequestMethod.POST)
    public String DeletePerson(@RequestParam("id") int id, Model model) {
        personService.delete(id);
        return getPersonPage(model);
    }

    @ModelAttribute("allKinds")
    public List<KindView> populateKinds() {
        List<KindView> kindViews = kindService.getAll();
        kindViews.sort((kind1, kind2) -> kind1.getDetails().compareTo(kind2.getDetails()));
        return kindViews;
    }

    @ModelAttribute("allGenders")
    public  List<GenderView> populateGenders() {
        List<GenderView> genderViews = genderService.getAll();
        genderViews.sort((gender1, gender2) -> gender1.getDescription().compareTo(gender2.getDescription()));
        return  genderViews;
    }

    private Date parseDate(String dateString) {
        Date date;
        try {
            date = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
        } catch (ParseException e) {
            date = null;
        }
        return date;
    }
}
