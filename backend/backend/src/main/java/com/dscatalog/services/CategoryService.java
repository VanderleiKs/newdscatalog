package com.dscatalog.services;

import java.util.List;

import com.dscatalog.entities.Category;
import com.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category add(Category category){
        return categoryRepository.save(category);
    }
}
