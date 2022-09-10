package com.example.relationaldatabase.onetomany;

import com.example.relationaldatabase.onetomany.onedirection.AddNativeRequest;
import com.example.relationaldatabase.onetomany.onedirection.Cohort;
import com.example.relationaldatabase.onetomany.onedirection.CohortService;
import com.example.relationaldatabase.onetomany.onedirection.NativeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NativeServiceImplTest {
    @Autowired
    private NativeService nativeService;
    @Autowired
    private CohortService cohortService;

    @Test
    public void testToAddNative(){

        /*
        THIS IS A BAD IDEA CAUSE A NEW COHORT IS CREATED EVERY TIME A STUDENT IS SAVED.
        DO NOT USE THIS METHOD. LOOK AT THE NEXT TEST
        * 1. only the native has relationship with the cohort. no cascade was used
        * result: threw a transient property error i.e does not know what to do with the cohort
        * 2. cascade save all was used and it worked, saved the native and cohort
        * */
        Cohort cohort = new Cohort();
        cohort.setName("dekanorbs");

        AddNativeRequest addNativeRequest = AddNativeRequest.builder()
                .firstName("sikiru")
                .lastName("akinsola")
                .cohort(cohort)
                .build();
        var response = nativeService.addNative(addNativeRequest);
        assertEquals("added", response);
    }
    @Test
    public void testToAddNativeAnother(){

        /*
         * 1. only the native has relationship with the cohort. no cascade was used
         * result: it worked cause cohort was gotten from an already created cohort in the database
         *if a number of natives are in same cohort, just the reference of the cohorts will be added
         * i.e just one type of that cohort is in the database but id reference in lotta places on
         * the native table
         *
         * if cascade all is used here, it throws a detached entity passed to persist because the cohort
         * entity used here was created separately, so the student can not save(persist) a saved(detached)
         *  entity
         *
         * when cascade detach was used, it passed(didnt save a new cohort but used the already created one)
         * */
        Long id = 4L;
        Cohort cohort = cohortService.getCohortById(id);

        AddNativeRequest addNativeRequest = AddNativeRequest.builder()
                .firstName("akin")
                .lastName("akinsola")
                .cohort(cohort)
                .build();
        var response = nativeService.addNative(addNativeRequest);
        assertEquals("added", response);
    }
    @Test
    public void testToDeleteAStudent(){
        /*
        * no cascade was used, native was deleted but cohort was not deleted cause native did no create cohort
        * */
        Long id = 6L;
        String response = nativeService.deleteNative(id);
        assertEquals("deleted", response);
    }

}