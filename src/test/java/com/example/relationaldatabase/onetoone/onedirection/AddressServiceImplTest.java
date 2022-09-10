package com.example.relationaldatabase.onetoone.onedirection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceImplTest {
    @Autowired
    private AddressServiceImpl addressService;

    @Test
    void deleteAddress() {
      String response =  addressService.deleteAddress(2L);
      assertEquals("deleted", response);
      /*
      * did not work cause a parent row can not be updated(since the child pk is a foreign key in the parent
      * table, if deleted, how is the parent table going to be updated? so a child can not be deleted in this
      * kinda situation)
      *
      *
      * */
    }
}