package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.HourDto;

public interface HourService {

    void saveHour(HourDto hourDto, String businessId);

    HourDto getHourByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
