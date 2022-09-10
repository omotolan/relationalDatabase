package com.example.relationaldatabase.onetoone.bidirectional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BiAddressServiceImpl implements BiAddressService {
    @NonNull
    private BiAddressRepository biAddressRepository;

    @Override
    public BiAddress getAddress(Long id) {

        return findAddressInternal(id);
    }

    private BiAddress findAddressInternal(Long id) {
        Optional<BiAddress> biAddress = biAddressRepository.findById(id);
        if (biAddress.isEmpty()) {
            throw new RuntimeException();
        }
        return biAddress.get();
    }

    @Override
    public String deleteAddress(Long id) {
       BiAddress address = findAddressInternal(id);
       biAddressRepository.delete(address);
        System.out.println(address.getUser().getFirstName());

        return "deleted";
    }
}
