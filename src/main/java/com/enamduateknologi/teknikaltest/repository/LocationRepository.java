package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    Optional<Location> findByBusinessId(String businessId);
}
