package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.repository.CustomerRepository;
import edu.mum.crswebapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer loginCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null;
    }
}
