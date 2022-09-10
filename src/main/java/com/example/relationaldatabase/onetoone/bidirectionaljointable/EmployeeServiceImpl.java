package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @NonNull
    private EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(AddEmployeeRequest addEmployeeRequest) {
        Employee employee = Employee.builder()
                .firstName(addEmployeeRequest.getFirstName())
                .lastName(addEmployeeRequest.getLastName())
                .workStation(addEmployeeRequest.getWorkStation())
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee.getFirstName() + " successfully added";
    }

    private Employee findEmployeeInternal(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new RuntimeException();
        }
        return employee.get();
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = findEmployeeInternal(id);
        employeeRepository.delete(employee);

        return "deleted";
    }
}
