package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.Customer;
import edu.mum.crswebapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Collection<Order>>  findOrdersByCustomer_CustomerId(Integer customerId);
}
