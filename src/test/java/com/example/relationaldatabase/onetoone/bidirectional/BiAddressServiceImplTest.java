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
        BiAddress foundAddress = biAddressService.getAddress(1L);
        assertEquals("Sikiru", foundAddress.getUser().getFirstName());
    }
    @Test
    public void testToDeleteAddress(){
        /*
        * want to check what happens whenever i delete an address.
        * 1. only annotation on the user field in the address model is 'mapped by' and 'cascade all' in the
        * other direction
        * result: was unable to delete the address. didnt delete
        * */
        Long id = 2L;
        String response = biAddressService.deleteAddress(id);
        assertEquals("deleted", response);
    }

}