package com.example.relationaldatabase.onetomany.bidirection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    @NonNull
    private ClassRepository classRepository;
}
