package com.example.relationaldatabase.onetoone.onedirection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl {

    @NonNull
    private AddressRepository addressRepository;

    public String deleteAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        addressRepository.delete(address.get());
        return  "deleted";

    }
}
