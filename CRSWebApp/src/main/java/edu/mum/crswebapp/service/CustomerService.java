package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.Customer;

import java.util.List;

public interface CustomerService {

    public abstract List<Customer> getAllCustomers();

    public abstract Customer getCustomer(Integer customerId);

    public abstract Customer createCustomer(Customer customer);
}
