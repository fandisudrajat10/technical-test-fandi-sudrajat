package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.domain.BusinessCategory;
import com.enamduateknologi.teknikaltest.domain.Category;
import com.enamduateknologi.teknikaltest.dto.CategoryDto;
import com.enamduateknologi.teknikaltest.repository.BusinessCategoryRepository;
import com.enamduateknologi.teknikaltest.service.BusinessCategoryService;
import com.enamduateknologi.teknikaltest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BusinessCategoryServiceImpl implements BusinessCategoryService {

    @Autowired
    private BusinessCategoryRepository businessCategoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void saveBusinessCategory(List<CategoryDto> categoryDtoList, String businessId) {
        deleteByBusinessId(businessId);
        for (CategoryDto categoryDto : categoryDtoList) {
            String categoryId = categoryService.saveCategory(categoryDto);
            Business business = new Business();
            business.setId(businessId);
            Category category = new Category();
            category.setId(categoryId);
            BusinessCategory businessCategory = new BusinessCategory();
            businessCategory.setBusiness(business);
            businessCategory.setCategory(category);
            businessCategoryRepository.save(businessCategory);
        }
    }

    @Override
    public List<CategoryDto> getAllCategoryByBusinessId(String businessId) {
        List<BusinessCategory> businessCategoryList = businessCategoryRepository.findAllByBusinessId(businessId);
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (BusinessCategory businessCategory: businessCategoryList){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setAlias(businessCategory.getCategory().getAlias());
            categoryDto.setTitle(businessCategory.getCategory().getTitle());
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        List<BusinessCategory> businessCategoryList = businessCategoryRepository.findAllByBusinessId(businessId);
        for (BusinessCategory businessCategory: businessCategoryList){
            businessCategoryRepository.delete(businessCategory);
        }
    }
}
