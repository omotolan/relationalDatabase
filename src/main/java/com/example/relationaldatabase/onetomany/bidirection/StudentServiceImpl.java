package com.example.relationaldatabase.onetomany.bidirection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @NonNull
    private StudentRepository studentRepository;

}
