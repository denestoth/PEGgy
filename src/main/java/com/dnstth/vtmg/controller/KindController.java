package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.dal.facade.KindFacade;
import com.dnstth.vtmg.view.KindView;
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
public class KindController {

    @Autowired
    KindFacade kindFacade;

    @RequestMapping(value = "/api/kind", method = RequestMethod.GET)
    public String getKindPage(Model model) {
        List<KindView> kindViews = kindFacade.getAll();
        model.addAttribute("kinds", kindViews);
        return "kind";
    }

    @RequestMapping(value = "/api/kind", method = RequestMethod.POST)
    public String addNewKind(@RequestParam("kindDetails") String kindDetails,
                             Model model) {
        KindView kindView = new KindView();
        kindView.setDetails(kindDetails);
        kindFacade.add(kindView);
        return getKindPage(model);
    }

    @RequestMapping(value = "/api/kind/delete", method = RequestMethod.POST)
    public String deleteKind(@RequestParam("id") int id,
                             Model model) {
        kindFacade.delete(id);
        return getKindPage(model);
    }

    @RequestMapping(value = "api/kind/update", method = RequestMethod.GET)
    public String updateKind(@RequestParam("id") int id,
                             Model model) {
        model.addAttribute("kind", kindFacade.getOne(id));
        return "editKind";
    }

    @RequestMapping(value = "api/kind/update", method = RequestMethod.POST)
    public String saveUpdateKind(@RequestParam("id") int id,
                                 @RequestParam("kindDetails") String kindDetails,
                                 Model model) {
        KindView kindView = kindFacade.getOne(id);
        kindView.setDetails(kindDetails);
        kindFacade.update(kindView);
        return getKindPage(model);
    }
}
