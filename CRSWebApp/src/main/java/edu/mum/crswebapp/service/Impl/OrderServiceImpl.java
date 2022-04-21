package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.model.Order;
import edu.mum.crswebapp.repository.CustomerRepository;
import edu.mum.crswebapp.repository.OrderRepository;
import edu.mum.crswebapp.service.OrderService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository,CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Collection<Order> getAllOrdersByCustomerId(Integer customerId) {
        Optional<Collection<Order>> optionalOrder = orderRepository.findOrdersByCustomer_CustomerId(customerId);
        if(optionalOrder.isPresent()){
            return optionalOrder.get();
        }
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order createOrder(Order order, Customer customer) {
        Optional<Customer> searchCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if(searchCustomer.isPresent()){
            order.setCustomer(searchCustomer.get());
            orderRepository.save(order);
        }else {
            Customer savedCustomer = customerRepository.save(customer);
            order.setCustomer(savedCustomer);
            orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order createOrderMobile(Order order) {
        Optional<Customer> searchCustomer = customerRepository.findCustomerByEmail(order.getCustomer().getEmail());
        if(searchCustomer.isPresent()){
            order.setCustomer(searchCustomer.get());
            orderRepository.save(order);
        }else {
            Customer savedCustomer = customerRepository.save(order.getCustomer());
            order.setCustomer(savedCustomer);
            orderRepository.save(order);
        }
        return null;
    }
}
