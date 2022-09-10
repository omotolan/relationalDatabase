package com.example.relationaldatabase.onetomany.onedirection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortRepository extends JpaRepository<Cohort, Long> {
}
