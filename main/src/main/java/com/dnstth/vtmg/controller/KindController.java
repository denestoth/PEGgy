package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.service.KindService;
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
    KindService kindService;

    @RequestMapping(value = "/api/kind", method = RequestMethod.GET)
    public String getKindPage(Model model) {
        List<KindView> kindViews = kindService.getAll();
        model.addAttribute("kinds", kindViews);
        return "kind";
    }

    @RequestMapping(value = "/api/kind", method = RequestMethod.POST)
    public String addNewKind(@RequestParam("kindDetails") String kindDetails, Model model) {
        KindView kindView = new KindView();
        kindView.setDetails(kindDetails);
        kindService.add(kindView);
        return getKindPage(model);
    }

    @RequestMapping(value = "/api/kind/delete", method = RequestMethod.POST)
    public String deleteKind(@RequestParam("id") int id, Model model) {
        kindService.delete(id);
        return getKindPage(model);
    }
}
