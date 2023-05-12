package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.SpecialHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialHourRepository extends JpaRepository<SpecialHour, String> {
    List<SpecialHour> findAllByBusinessId(String businessId);

    void deleteAllByBusinessId(String businessId);
}
