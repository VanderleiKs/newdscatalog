package com.dscatalog.services;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.dscatalog.dtos.CategoryDto;
import com.dscatalog.entities.Category;
import com.dscatalog.exceptions.NotFoundException;
import com.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public CategoryDto add(CategoryDto category) {
        return new CategoryDto(categoryRepository.save(new Category(category)));
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(long id) {
        return new CategoryDto(categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category "+id+" Not found")));
    }
}
