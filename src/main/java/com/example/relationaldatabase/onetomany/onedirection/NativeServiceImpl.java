package com.example.relationaldatabase.onetomany.onedirection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NativeServiceImpl implements NativeService{
    @NonNull
    private NativeRepository nativeRepository;

    @Override
    public String addNative(AddNativeRequest addNativeRequest) {
        Native aNative = Native.builder()
                .firstName(addNativeRequest.getFirstName())
                .lastName(addNativeRequest.getLastName())
                .cohort(addNativeRequest.getCohort())
                .build();
     Native savedNative =   nativeRepository.save(aNative);
     log.info("native's cohort name -. {}", savedNative.getCohort().getName());
        return "added";
    }
    private Native findNativeInternal(Long id){
        Optional<Native> aNative = nativeRepository.findById(id);
        if (aNative.isEmpty()){
            throw new RuntimeException();
        }
        return aNative.get();
    }
    @Override
    public String deleteNative(Long id) {
        Native aNative = findNativeInternal(id);
        nativeRepository.delete(aNative);
        return "deleted";
    }
}
