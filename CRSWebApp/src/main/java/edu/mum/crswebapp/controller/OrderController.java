package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Order;
import edu.mum.crswebapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"crs/secured/order"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = {"/list"})
    public ModelAndView displayOrderPage() {

        List<Order> orderList = orderService.getAllOrders();

        var modelAndView = new ModelAndView();
        modelAndView.addObject("orderList", orderList);
        modelAndView.setViewName("/secured/order/order");
        return modelAndView;
    }
}
