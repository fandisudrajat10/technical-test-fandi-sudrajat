package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.AttributesDto;

public interface AttributesService {

    void saveAttributes(AttributesDto attributesDto, String businessId);

    AttributesDto getAttributesByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
