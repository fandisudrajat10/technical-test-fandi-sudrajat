package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.BusinessRequestDto;
import com.enamduateknologi.teknikaltest.dto.BusinessSearchDto;
import org.springframework.data.domain.Page;

public interface BusinessService {

    void saveBusiness(BusinessRequestDto businessRequestDto);

    BusinessRequestDto getBusinessById(String id);

    void deleteBusinessById(String businessId);

    Page<BusinessRequestDto> findSearch(BusinessSearchDto businessSearchDto);
}
