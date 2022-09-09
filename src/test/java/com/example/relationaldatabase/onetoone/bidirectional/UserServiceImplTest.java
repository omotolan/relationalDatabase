package com.example.relationaldatabase.onetoone.bidirectional;

import com.example.relationaldatabase.onetoone.onedirection.AddPersonRequest;
import com.example.relationaldatabase.onetoone.onedirection.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testThatPersonCanBeCreated() {
        /*
        Bi directional
         * test that when person is added, the address saves in the database
         * cascade type all was used on user class here
         * result: it worked but put null value for user id on address
         *
         * check the address test
         * */
        BiAddress address = new BiAddress();
        address.setCity("Ikeja");
        address.setStreet("Emily Akinola");
        AddUserRequest addUserRequest = AddUserRequest.builder()
                .firstName("Sikiru")
                .lastName("akinsola")
                .address(address)
                .build();
        String response = userService.addUser(addUserRequest);
        assertEquals(addUserRequest.getFirstName() + " saved", response);
    }

    @Test
    public void testThatPersonCanBeDeleted() {
        /*
         * delete with cascade type all
         * result: the instance and relationship were deleted
         * second delete, cascade was on persist
         * result: the relationship address was not deleted but person deleted
         * */
        var id = 4L;
        String response = userService.deleteUser(id);
        assertEquals("deleted", response);
    }

}