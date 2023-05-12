package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.SpecialHourDto;

import java.util.List;

public interface SpecialHourService {
    void saveSpecialHours(List<SpecialHourDto> specialHoursDtos, String businessId);

    List<SpecialHourDto> getAllSpecialHoursByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
