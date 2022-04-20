package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.model.Employee;
import edu.mum.crswebapp.repository.EmployeeRepository;
import edu.mum.crswebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.getById(employeeId);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);

    }
    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
    @Override
    public List<Employee> view() {
        return null;
    }
}
