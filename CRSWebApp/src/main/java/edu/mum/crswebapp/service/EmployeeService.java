package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    public abstract List<Employee> getAllEmployees();
    public abstract Employee addEmployee(Employee employee);
    public abstract Employee getEmployeeById(Long employeeId);
    public abstract Employee updateEmployee(Employee employee);
    public abstract void deleteEmployee(Long employee);
    public abstract List<Employee> view ();
}
