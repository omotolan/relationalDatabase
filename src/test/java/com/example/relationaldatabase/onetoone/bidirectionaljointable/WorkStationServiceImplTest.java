package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WorkStationServiceImplTest {
    @Autowired
    private WorkStationService workStationService;

    @Test
    public void testThatWorkStationCanBeDeleted(){
        /*
        *employee the parent and workstation the child
        * delete method did not work
        * but works if the parent is  deleted first(persist)
        * */
        Long id = 1L;
        var response = workStationService.deleteWorkStation(id);
        assertEquals("deleted", response);
    }

}