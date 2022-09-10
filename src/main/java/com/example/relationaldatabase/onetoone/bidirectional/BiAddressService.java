package com.example.relationaldatabase.onetoone.bidirectional;


public interface BiAddressService {
    BiAddress getAddress(Long id);

    String deleteAddress(Long id);
}
