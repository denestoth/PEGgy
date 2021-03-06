package com.dnstth.vtmg.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.dnstth.vtmg.dal.facade.GenderFacade;
import com.dnstth.vtmg.dal.facade.KindFacade;
import com.dnstth.vtmg.dal.facade.PersonFacade;
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

/**
 * Created by Denes_Toth
 */
@Controller
public class PersonController {

    @Autowired
    private PersonFacade personFacade;

    @Autowired
    private GenderFacade genderFacade;

    @Autowired
    private KindFacade kindFacade;

    @RequestMapping(value = "/api/person", method = RequestMethod.GET)
    public String getPersonPage(Model model) {
        List<PersonView> personViews = personFacade.getAll();
        model.addAttribute("people", personViews);
        return "person";
    }

    @RequestMapping(value = "/api/person", method = RequestMethod.POST)
    public String addNewPerson(
        @RequestParam("personName") String personName,
        @RequestParam("personBirthDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date personBirthDate,
        @RequestParam("personDeathDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date personDeathDate,
        @RequestParam("personDetails") String personDetails,
        @RequestParam("personGenderId") int personGenderId,
        @RequestParam("personKindId") int personKindId,
        Model model
    ) {
        PersonView personView = PersonView.builder()
                                    .name(personName)
                                    .birthDate(personBirthDate)
                                    .deathDate(personDeathDate)
                                    .details(personDetails)
                                    .gender(genderFacade.getOne(personGenderId))
                                    .kind(kindFacade.getOne(personKindId))
                                    .events(Collections.emptyList())
                                    .build();
        personFacade.add(personView);
        return getPersonPage(model);
    }

    @RequestMapping(value = "/api/person/delete", method = RequestMethod.POST)
    public String deletePerson(
        @RequestParam("id") int id,
        Model model
    ) {
        try {
            personFacade.delete(id);
        } catch (Exception e) {
            model.addAttribute("error", "Could not delete entry, other entries depending on it.");
        }
        return getPersonPage(model);
    }

    @RequestMapping(value = "/api/person/update", method = RequestMethod.GET)
    public String updatePerson(
        @RequestParam("id") int id,
        Model model
    ) {
        model.addAttribute("person", personFacade.getOne(id));
        return "editPerson";
    }

    @RequestMapping(value = "/api/person/update", method = RequestMethod.POST)
    public String saveUpdatePerson(
        @RequestParam("id") int id,
        @RequestParam("personName") String personName,
        @RequestParam("personBirthDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date personBirthDate,
        @RequestParam("personDeathDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date personDeathDate,
        @RequestParam("personDetails") String personDetails,
        @RequestParam("personGenderId") int personGenderId,
        @RequestParam("personKindId") int personKindId,
        Model model
    ) {
        PersonView personView = personFacade.getOne(id);
        personView.setName(personName);
        personView.setBirthDate(personBirthDate);
        personView.setDeathDate(personDeathDate);
        personView.setDetails(personDetails);
        personView.setGender(genderFacade.getOne(personGenderId));
        personView.setKind(kindFacade.getOne(personKindId));
        personFacade.update(personView);
        return getPersonPage(model);
    }

    @ModelAttribute("allKinds")
    public List<KindView> populateKinds() {
        List<KindView> kindViews = kindFacade.getAll();
        kindViews.sort((kind1, kind2) -> kind1.getDetails().compareTo(kind2.getDetails()));
        return kindViews;
    }

    @ModelAttribute("allGenders")
    public List<GenderView> populateGenders() {
        List<GenderView> genderViews = genderFacade.getAll();
        genderViews.sort((gender1, gender2) -> gender1.getDescription().compareTo(gender2.getDescription()));
        return genderViews;
    }
}
