package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, String> {
    List<BusinessCategory> findAllByBusinessId(String businessId);

    void deleteAllByBusinessId(String businessId);
}
