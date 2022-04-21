package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.*;
import edu.mum.crswebapp.service.OrderService;
import edu.mum.crswebapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"crs/secured/order"})
public class OrderController {
    private OrderService orderService;

    @Autowired
    private VehicleService vehicleService;

    private Vehicle selectedVehicle;
    private Order selectedOrder;

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

    @GetMapping(value = {"/orderDetail"})
    public String displayOrderDetail(Model model) {
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();
        model.addAttribute("order", new Order(
                null, null,
                LocalDate.now().toString(),
                LocalDate.now().toString(),
                "Booked", new Vehicle(), new Customer()));
        return "secured/order/orderInfo";
    }

    @PostMapping(value = {"/orderDetail"})
    public String addOrderInfo(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("order", order);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/order/orderInfo";
        }
        selectedOrder = order;
        return "redirect:/crs/secured/order/new";
    }

    @GetMapping(value = {"/new"})
    public ModelAndView displayNewOrderForm(Model model) {
        selectedVehicle = null;
        ModelAndView modelAndView = new ModelAndView();
        List<Vehicle> vehicleList = vehicleService.getAllVehicle();
        modelAndView.addObject("vehicleList", vehicleList);
        modelAndView.setViewName("secured/order/new");

        return modelAndView;
    }

    @GetMapping(value = {"/choose/{vehicleId}"})
    public String addOrderCustomer(@PathVariable Long vehicleId, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        if(vehicle != null) {
            selectedVehicle = vehicle;
            model.addAttribute("vehicle",vehicle);
            model.addAttribute("customer",new Customer(null,null,null,null,null, new Address()));
            return "secured/order/customerInfo";
        }
        return "redirect:/crs/secured/order/new";
    }

    @PostMapping(value = {"/vehicle"})
    public String registerNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/order/customerInfo";
        }

        selectedOrder.setVehicle(selectedVehicle);
        orderService.createOrder(selectedOrder,customer);
        return "redirect:/crs/secured/order/list";
    }
}
