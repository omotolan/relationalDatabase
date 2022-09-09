package com.example.relationaldatabase.onetoone.bidirectional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiAddressServiceImplTest {
    @Autowired
    private BiAddressService biAddressService;

    @Test
    public void testToGetUser() {
        /*
         * bi direction was used and "mapped by" was used on the user field in the address model,
         * a find address by id was done and it returned the user also tho the user column is not showing
         * in the address table
         * */
        BiAddress foundAddress = biAddressService.getUser(1L);
        assertEquals("Sikiru", foundAddress.getUser().getFirstName());
    }

}