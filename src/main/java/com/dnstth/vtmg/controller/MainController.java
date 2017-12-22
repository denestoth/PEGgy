package com.dnstth.vtmg.controller;

import com.dnstth.vtmg.graph.SomeGraphCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Denes_Toth
 */

@Controller
public class MainController {

    @Autowired
    private SomeGraphCreator someGraphCreator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        some();
        return "index";
    }

    private void some() {
        someGraphCreator.doSomeGraph();
    }

}
