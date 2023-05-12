package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.LocationDto;

public interface LocationService {

    void saveLocation(LocationDto locationDto, String businessId);

    LocationDto getLocationByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
