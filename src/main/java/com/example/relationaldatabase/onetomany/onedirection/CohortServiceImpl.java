package com.example.relationaldatabase.onetomany.onedirection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CohortServiceImpl implements CohortService{
    @NonNull
    private CohortRepository cohortRepository;


    @Override
    public String addCohort(AddCohortRequest addCohortRequest) {
        Cohort cohort = new Cohort();
        cohort.setName(addCohortRequest.getName());
        cohortRepository.save(cohort);

        return "added";
    }
    private Cohort findCohortInternal(Long id){
        Optional<Cohort> cohort = cohortRepository.findById(id);
        if (cohort.isEmpty()){
            throw  new RuntimeException();
        }
        return cohort.get();
    }
    @Override
    public Cohort getCohortById(Long id){
        return findCohortInternal(id);
    }
}
