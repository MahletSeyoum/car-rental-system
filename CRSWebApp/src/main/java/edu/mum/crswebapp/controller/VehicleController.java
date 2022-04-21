package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Vehicle;
import edu.mum.crswebapp.model.VehicleType;
import edu.mum.crswebapp.service.VehicleService;
import edu.mum.crswebapp.service.VehicleTypeService;
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

@Controller
@RequestMapping(path = {"crs/secured/vehicle"})
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping(value = {"/list"})
    public ModelAndView listVehicles(){
        var modelAndView = new ModelAndView();
        modelAndView.addObject("vehicles", vehicleService.getAllVehicles());
        modelAndView.setViewName("secured/vehicle/vehicles");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewVehicleForm(Model model) {
        List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicle", new Vehicle(null,null, null, null,null,null,null,null,null));
        model.addAttribute("vehicleTypes", vehicleTypes);
        return "secured/vehicle/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
                                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/vehicle/new";
        }
        vehicleService.addVehicles(vehicle);
        return "redirect:/crs/secured/vehicle/list";
    }

    @GetMapping(value = {"/edit/{vehicleId}"})
    public String editVehicle(@PathVariable Long vehicleId, Model model) {
        var vehicle = vehicleService.getVehicleById(vehicleId);
        List<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
        if (vehicle != null) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("vehicleTypes", vehicleTypes);
            return "secured/vehicle/edit";
        }
        return "redirect:/crs/secured/vehicle/list";
    }

    @PostMapping(value = {"/update"})
    public String updatevehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/vehicle/edit";
        }
        vehicleService.addVehicles(vehicle);
        return "redirect:/crs/secured/vehicle/list";
    }

    @GetMapping(value = {"/delete/{vehicleId}"})
    public String deletePublisher(@PathVariable Long vehicleId) {
        vehicleService.deletePublisherById(vehicleId);
        return "redirect:/vehicle/list";
    }
}
