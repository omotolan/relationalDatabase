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
    public BiAddress getUser(Long id) {
        Optional<BiAddress> biAddress = biAddressRepository.findById(id);
        return biAddress.get();
    }
}
