package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.repository.CustomerRepository;
import edu.mum.crswebapp.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
