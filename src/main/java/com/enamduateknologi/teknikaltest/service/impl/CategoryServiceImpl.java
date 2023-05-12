package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Category;
import com.enamduateknologi.teknikaltest.dto.CategoryDto;
import com.enamduateknologi.teknikaltest.repository.CategoryRepository;
import com.enamduateknologi.teknikaltest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public String saveCategory(CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepository.findByAlias(categoryDto.getAlias());
        if (categoryOptional.isPresent()){
            return categoryOptional.get().getId();
        } else {
            Category category = new Category();
            category.setAlias(categoryDto.getAlias());
            category.setTitle(categoryDto.getTitle());
            Category categorySave = categoryRepository.save(category);
            return categorySave.getId();
        }
    }
}
