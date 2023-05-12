package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.PhotoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDetailRepository extends JpaRepository<PhotoDetail, String> {
    List<PhotoDetail> findAllByBusinessId(String businessId);

    void deleteAllByBusinessId(String businessId);
}
