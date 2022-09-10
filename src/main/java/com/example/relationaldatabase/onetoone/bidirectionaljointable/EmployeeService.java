package com.example.relationaldatabase.onetoone.bidirectionaljointable;

public interface EmployeeService {
    String addEmployee(AddEmployeeRequest addEmployeeRequest);
    String deleteEmployee(Long id);
}
