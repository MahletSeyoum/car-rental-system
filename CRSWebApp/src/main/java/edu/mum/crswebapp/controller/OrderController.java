package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.*;
import edu.mum.crswebapp.service.OrderService;
import edu.mum.crswebapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"crs/secured/order"})
public class OrderController {

    private OrderService orderService;

    @Autowired
    private VehicleService vehicleService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView displayOrderPage() {

        List<Order> orderList = orderService.getAllOrders();

        var modelAndView = new ModelAndView();
        modelAndView.addObject("orderList", orderList);
        modelAndView.setViewName("/secured/order/order");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public ModelAndView displayNewOrderForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();
        model.addAttribute("order", new Order(
                null, null,
                LocalDate.now(),
                LocalDate.now(),
                null, new Vehicle(), new Customer()));
        modelAndView.addObject("vehicleList", vehicleList);
        modelAndView.setViewName("secured/order/new");

        return modelAndView;
    }

    @GetMapping(value = {"/choose/{vehicleId}"})
    public String editEmployee(@PathVariable Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);

        System.out.println("aksdhfkjashfjhaskjfhakjshfjkashfkjashfkasdkfhaskjfhkjasd ---- -- - -- - - - -- -- - ");
        System.out.println(vehicle);
        if(vehicle != null) {
            model.addAttribute("vehicle", vehicle);
            return "secured/order/new";
        }
        return "redirect:/crs/secured/order/new";
    }
}
