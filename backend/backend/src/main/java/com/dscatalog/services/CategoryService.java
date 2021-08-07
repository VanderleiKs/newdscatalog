package com.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import com.dscatalog.dtos.CategoryDto;
import com.dscatalog.entities.Category;
import com.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
            .map(CategoryDto::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public Category add(Category category) {
        return categoryRepository.save(category);
    }
}
