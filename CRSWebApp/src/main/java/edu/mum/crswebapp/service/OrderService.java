package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.model.Order;

import java.util.Collection;
import java.util.List;

public interface OrderService {

    public abstract List<Order> getAllOrders();

    public abstract Collection<Order> getAllOrdersByCustomerId(Integer customerId);

    public abstract  Order createOrder(Order order);

    public abstract  Order createOrder(Order order, Customer customer);


    public abstract  Order createOrderMobile(Order order);

}
