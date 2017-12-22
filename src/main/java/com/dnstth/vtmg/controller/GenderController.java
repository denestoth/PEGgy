package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.facade.GenderFacade;
import com.dnstth.vtmg.view.GenderView;
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
public class GenderController {

    @Autowired
    private GenderFacade genderFacade;

    @RequestMapping(value = "/api/gender", method = RequestMethod.GET)
    public String getGenderPage(Model model) {
        List<GenderView> genderViews = genderFacade.getAll();
        model.addAttribute("genders", genderViews);
        return "gender";
    }

    @RequestMapping(value = "/api/gender", method = RequestMethod.POST)
    public String addNewGender(@RequestParam("genderDescription") String genderDescription,
                               Model model) {
        GenderView genderView = new GenderView();
        genderView.setDescription(genderDescription);
        genderFacade.add(genderView);
        return getGenderPage(model);
    }

    @RequestMapping(value = "/api/gender/delete", method = RequestMethod.POST)
    public String deleteGender(@RequestParam("id") int id,
                               Model model) {
        try {
            genderFacade.delete(id);
        } catch (Exception e) {
            model.addAttribute("error", "Could not delete entry, other entries depending on it.");
        }
        return getGenderPage(model);
    }

    @RequestMapping(value = "/api/gender/update", method = RequestMethod.GET)
    public String updateGender(@RequestParam("id") int id,
                               Model model) {
        model.addAttribute("gender", genderFacade.getOne(id));
        return "editGender";
    }

    @RequestMapping(value = "/api/gender/update", method = RequestMethod.POST)
    public String saveUpdateGender(@RequestParam("id") int id,
                                   @RequestParam("genderDescription") String genderDescription,
                                   Model model) {
        GenderView genderView = genderFacade.getOne(id);
        genderView.setDescription(genderDescription);
        genderFacade.update(genderView);
        return getGenderPage(model);
    }
}
