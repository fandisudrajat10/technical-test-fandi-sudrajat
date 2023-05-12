package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDataRepository extends JpaRepository<Business, String> {
}
