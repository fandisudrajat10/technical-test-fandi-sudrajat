package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.CategoryDto;

import java.util.List;

public interface BusinessCategoryService {

    void saveBusinessCategory(List<CategoryDto> categoryDtoList, String businessId);

    List<CategoryDto> getAllCategoryByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
