package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.service.GenderService;
import com.dnstth.vtmg.service.PersonService;
import com.dnstth.vtmg.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by Denes_Toth
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private GenderService genderService;

    @RequestMapping(value="/api/person", method= RequestMethod.GET)
    public String getPersonPage(Model model) {
        List<PersonView> personViews = personService.getAll();
        model.addAttribute("people", personViews);
        return "person";
    }

    @RequestMapping(value="/api/person", method=RequestMethod.POST)
    public String addNewPerson(@RequestParam("personName") String personName,
                                @RequestParam("personBirthDate") Date personBirthDate,
                                @RequestParam("personDeathDate") Date personDeathDate,
                                @RequestParam("personDetails") String personDetails,
                                @RequestParam("personGenderId") int personGenderId,
                                Model model) {
        PersonView personView = new PersonView();
        personView.setName(personName);
        personView.setBirthDate(personBirthDate);
        personView.setDeathDate(personDeathDate);
        personView.setDetails(personDetails);
        personView.setGender(genderService.getAll().stream().filter(gv -> gv.getId() == personGenderId).findFirst().orElse(null));
        personService.add(personView);
        return getPersonPage(model);
    }

    @RequestMapping(value="/api/person/delete", method=RequestMethod.DELETE)
    public String DeletePerson(@RequestParam("id") int id, Model model) {
        personService.delete(id);
        return getPersonPage(model);
    }
}
