package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Vehicle;
import edu.mum.crswebapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://10.200.3.125:8088/")
@RestController
@RequestMapping(path = {"crs/api/v1/vehicle"})
public class VehilceRController {


    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "/")
    public ResponseEntity<?> getVehicles() {
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();

        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }
}

