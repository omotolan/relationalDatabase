package com.example.relationaldatabase.onetoone;

import com.example.relationaldatabase.onetoone.onedirection.AddPersonRequest;
import com.example.relationaldatabase.onetoone.onedirection.Address;
import com.example.relationaldatabase.onetoone.onedirection.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testThatPersonCanBeCreated(){
        /*
         * test that when person is added, the address saves in the database
         * cascade type all was used here
         * result: it worked
         *
         * second run of the test:
         * cascade wasn't used and it threw an error, transientpropertyvalueexception
         * */
        Address address = new Address();
        address.setCity("Ikeja");
        address.setStreet("Emily Akinola");
        AddPersonRequest addPersonRequest = AddPersonRequest.builder()
                .firstName("Sikiru")
                .lastName("akinsola")
                .address(address)
                .build();
        String response = personService.addPerson(addPersonRequest);
        assertEquals(addPersonRequest.getFirstName() + " saved", response);
    }
    @Test
    public void testThatPersonCanBeDeleted(){
        /*
        * delete with cascade type all
        * result: the instance and relationship were deleted
        * second delete, cascade was on persist
        * result: the relationship address was not deleted but person deleted
        * */
        var id = 4L;
        String response = personService.deleteUser(id);
        assertEquals("deleted", response);
    }

}