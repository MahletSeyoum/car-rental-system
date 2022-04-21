package edu.mum.crswebapp.controller;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.model.Order;
import edu.mum.crswebapp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://172.19.140.16:8088/")
@RestController
@RequestMapping(path = "crs/api/v1/order")
public class OrderRController {

    private OrderService orderService;

    OrderRController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<?> getOrders(@PathVariable String customerId){
        Collection<Order> orderList = orderService.getAllOrdersByCustomerId(Integer.parseInt(customerId));
        if(orderList.size() == 0){
            return new ResponseEntity<String>("No Orders Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @PostMapping(value = {"/createOrder"})
    public ResponseEntity<?> registerNewCustomer(@RequestBody Order order) {
        System.out.println(order);
        Order order1 = orderService.createOrderMobile(order);
        return new ResponseEntity<Order>(order1, HttpStatus.OK);
    }
}
