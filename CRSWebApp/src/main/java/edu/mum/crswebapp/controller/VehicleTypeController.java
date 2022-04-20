package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.VehicleType;
import edu.mum.crswebapp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"crs/secured/vehicletype"})
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;


    @GetMapping(value = {"/list"})
    public ModelAndView displayVehicleTypeList(){
        var modelAndView = new ModelAndView();
        modelAndView.addObject("vehicleTypeLists" ,vehicleTypeService.getVehicleTypes());
        modelAndView.setViewName("secured/vehicleType/vehicletype");
        return modelAndView;
    }


    @GetMapping(value = "/new")
    public String displayNewVehicleTypeForm(Model model) {
        model.addAttribute("vehicleType", new VehicleType());
        return "secured/vehicleType/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewPublisher(@Valid @ModelAttribute("vehicleType") VehicleType vehicleType,
                                       BindingResult bindingResult, Model model) {

        System.out.println(vehicleType);
        if(bindingResult.hasErrors()) {
            model.addAttribute("vehicleType", vehicleType);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/vehicleType/new";
        }
        vehicleTypeService.addVehicleType(vehicleType);
        return "redirect:/crs/secured/vehicletype/list";
    }

    @GetMapping(value = {"/edit/{vehicleTypeId}"})
    public String editVehicleType(@PathVariable Long vehicleTypeId, Model model) {
        var vehicleType = vehicleTypeService.getVehicleTypeById(vehicleTypeId);
        if (vehicleType != null) {
            model.addAttribute("vehicleType", vehicleType);
            return "secured/vehicleType/edit";
        }
        return "redirect:/crs/secured/vehicleType/list";
    }

    @PostMapping(value = {"/update"})
    public String updatevehicletype(@Valid @ModelAttribute("vehicletype") VehicleType vehicleType,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("vehicleType", vehicleType);
            model.addAttribute("errors", bindingResult.getAllErrors());
        }
        vehicleTypeService.addVehicleType(vehicleType);
        return "redirect:/crs/secured/vehicletype/list";
    }
    @GetMapping(value = {"/delete/{vehicleTypeId}"})
    public String deleteVehicleType(@PathVariable Long vehicleTypeId) {
        vehicleTypeService.removeVehicleType(vehicleTypeId);
        return "redirect:/crs/secured/vehicletype/list";

    }


}
