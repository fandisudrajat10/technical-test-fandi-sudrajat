package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HourRepository extends JpaRepository<Hour, String> {
    Optional<Hour> findByBusinessId(String businessId);
}
