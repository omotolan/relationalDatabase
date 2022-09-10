package com.example.relationaldatabase.onetomany.onedirection;

public interface CohortService {
    String addCohort(AddCohortRequest addCohortRequest);
    Cohort getCohortById(Long id);
}
