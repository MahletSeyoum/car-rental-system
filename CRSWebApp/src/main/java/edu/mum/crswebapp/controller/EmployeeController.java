package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Address;
import edu.mum.crswebapp.model.Employee;
import edu.mum.crswebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"crs/secured/employee"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listEmployee() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getAllEmployees());
        modelAndView.setViewName("/secured/employee/employee");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee(null, null, null, null, new Address()));
        return "secured/employee/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/secured/employee/new";
        }
        employeeService.addEmployee(employee);
        return "redirect:/crs/secured/employee/list";
    }

    @GetMapping(value = {"/edit/{employeeId}"})
    public String editEmployee(@PathVariable Long employeeId, Model model) {
        var employee = employeeService.getEmployeeById(employeeId);
        if(employee != null) {
            model.addAttribute("employee", employee);
            return "secured/employee/edit";
        }
        return "redirect:/crs/secured/employee/list";
    }

    @PostMapping(value = {"/update"})
    public String updatePublisher(@Valid @ModelAttribute("employee") Employee employee,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/employee/edit";
        }
        employeeService.addEmployee(employee);
        return "redirect:/crs/secured/employee/list";
    }

    @GetMapping(value = {"/delete/{employeeId}"})
    public String deleteEmployee(@PathVariable Long employeeId) {
      employeeService.deleteEmployee(employeeId);
        return "redirect:/crs/secured/employee/list";

    }
}