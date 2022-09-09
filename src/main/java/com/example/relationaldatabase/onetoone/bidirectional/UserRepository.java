package com.example.relationaldatabase.onetoone.bidirectional;

import com.example.relationaldatabase.onetoone.onedirection.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
