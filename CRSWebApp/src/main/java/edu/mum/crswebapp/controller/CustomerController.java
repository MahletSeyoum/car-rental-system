package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Address;
import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.model.Employee;
import edu.mum.crswebapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"crs/secured/customer"})
public class CustomerController {

    @Autowired
   private CustomerService customerService;

    @GetMapping(value = {"/list"})
    public ModelAndView listCustomer() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("customer", customerService.getAllCustomers());
        modelAndView.setViewName("/secured/customer/customer");
        return modelAndView;
    }


    @GetMapping(path = "/")
    public String displayNewCustomer(Model model){
     model.addAttribute("customer", new Customer(null,null,null,null,null, new Address()));
        return "secured/customer/new";
    }
    @PostMapping(value = {"/new"})
    public String registerNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        System.out.println("fgdfgsdfgsdfgdsfgdfgsdfgsdg-------------------");

        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/customer/";
        }
       customerService.createCustomer(customer);
        return "redirect:/crs/secured/customer/list";
    }




    @GetMapping(value = {"/edit/{customerId}"})
    public String editCustomer(@PathVariable Integer customerId, Model model) {
        var customer = customerService.getCustomer(customerId);
        if(customer != null) {
            model.addAttribute("customer", customerId);
            return "secured/customer/edit";
        }
        return "redirect:/crs/secured/customer/list";
    }

    @PostMapping(value = {"/update"})
    public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/customer/edit";
        }
        customerService.createCustomer(customer);
        return "redirect:/crs/secured/customer/list";
    }



}



