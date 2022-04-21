package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.service.CustomerService;
import edu.mum.crswebapp.service.impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://172.19.140.16:8088/")
@RestController
@RequestMapping(path = "crs/api/v1/customer")
public class CustomerRController {

    private CustomerService customerService;

    CustomerRController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerId){
        Customer customer = customerService.getCustomer(Integer.parseInt(customerId));

        if(customer == null){
            return new ResponseEntity<String>("No Customer Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        Customer customer1 = customerService.createCustomer(customer);
        return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> customerLogin(@RequestBody Customer customer){
        System.out.println(customer);
        Customer customer1 = customerService.loginCustomer(customer);
        if(customer != null){
            return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
        }
        return new ResponseEntity<>(customer1, HttpStatus.NOT_FOUND);
    }
}
