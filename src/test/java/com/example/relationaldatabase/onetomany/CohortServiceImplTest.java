package com.example.relationaldatabase.onetomany;

import com.example.relationaldatabase.onetomany.onedirection.AddCohortRequest;
import com.example.relationaldatabase.onetomany.onedirection.Cohort;
import com.example.relationaldatabase.onetomany.onedirection.CohortService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CohortServiceImplTest {
    @Autowired
    private CohortService cohortService;

    @Test
    public void addCohort(){
        AddCohortRequest addCohortRequest = new AddCohortRequest();
        addCohortRequest.setName("juno");
       String response =  cohortService.addCohort(addCohortRequest);
       assertEquals("added", response);
    }
    @Test
    public void testToGetACohort(){
        Long id = 3L;
        Cohort cohort = cohortService.getCohortById(id);
        assertEquals("juno", cohort.getName());
    }

}