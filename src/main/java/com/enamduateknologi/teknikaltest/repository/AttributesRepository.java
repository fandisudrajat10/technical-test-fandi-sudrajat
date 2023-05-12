package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, String> {
    Optional<Attributes> findByBusinessId(String businessId);
}
