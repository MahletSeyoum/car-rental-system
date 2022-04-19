package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
