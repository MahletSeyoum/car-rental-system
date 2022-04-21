package edu.mum.crswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = {"crs/public",""})
public class HomePageController {

    @GetMapping(path = {"/"})
    public ModelAndView displayHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("public/index");
        return modelAndView;
    }
}
