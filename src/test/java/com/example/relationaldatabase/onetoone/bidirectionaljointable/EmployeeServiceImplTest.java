package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testToCreateEmployee() {
        WorkStation workStation = new WorkStation();
        workStation.setLaptop("dell");
        workStation.setMonitor("samsung");
        AddEmployeeRequest addEmployeeRequest = AddEmployeeRequest.builder()
                .firstName("tolani")
                .lastName("akinsola")
                .workStation(workStation)
                .build();
        String response = employeeService.addEmployee(addEmployeeRequest);
        assertEquals(addEmployeeRequest.getFirstName() + " successfully added", response);
    }

    @Test
    public void testToDeleteEmployee() {
        Long id = 1L;
        /*
         * the parent model was deleted while cascade was on persist, the column was deleted and the join table
         * was deleted also. The child column on the child model was left unaffected.
         * when delete was ran on the child after parent was deleted, it worked.
         * */
        var response = employeeService.deleteEmployee(id);
        assertEquals("deleted", response);

    }
}