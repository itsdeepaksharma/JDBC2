package com.company.dao;

import com.company.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
