package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
