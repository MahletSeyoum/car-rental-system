package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    public abstract List<Customer> getAllCustomers();

    public abstract Customer getCustomer(Integer customerId);

    public abstract Customer createCustomer(Customer customer);

    public abstract Customer loginCustomer(Customer customer);
}
