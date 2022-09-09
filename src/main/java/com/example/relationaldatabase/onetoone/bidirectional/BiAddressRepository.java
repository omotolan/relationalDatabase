package com.example.relationaldatabase.onetoone.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BiAddressRepository extends JpaRepository<BiAddress, Long> {
}
