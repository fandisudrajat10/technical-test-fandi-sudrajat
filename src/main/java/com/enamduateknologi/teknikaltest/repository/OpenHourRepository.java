package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.OpenHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenHourRepository extends JpaRepository<OpenHour, String> {
    List<OpenHour> findAllByHourId(String hourId);

    void deleteAllByHourId(String hourId);
}
