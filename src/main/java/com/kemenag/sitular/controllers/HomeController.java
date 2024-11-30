package com.kemenag.sitular.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("page", "index");

        return model;
    }
}
