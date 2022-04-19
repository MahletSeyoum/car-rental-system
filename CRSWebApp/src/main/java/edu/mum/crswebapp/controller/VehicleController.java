package edu.mum.crswebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "crs/api/v1/vehicle")
public class VehicleController {

    @GetMapping(path = "/")
    public List<String> getVehicles() {
        List<String> list = new ArrayList<String>();
        list.add("Vehicle1");
        list.add("Vehicle2");
        return list;
    }
}
