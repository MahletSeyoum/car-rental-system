package edu.mum.crswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/crs/public/login"})
    public String login() {
        return "public/login";
    }

}
