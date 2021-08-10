package com.dscatalog.services;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.dscatalog.dtos.CategoryDto;
import com.dscatalog.entities.Category;
import com.dscatalog.exceptions.DatabaseException;
import com.dscatalog.exceptions.NotFoundException;
import com.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;

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

    @Transactional
    public CategoryDto update(Long id, CategoryDto dto) {
        try {
            Category entity = categoryRepository.getOne(id);
            entity.setName(dto.getName());
            return new CategoryDto(categoryRepository.save(entity));
        }
        catch (EntityNotFoundException ex){
            throw new NotFoundException("Id "+id+" not found");
        }
    }

    public void delete(Long id){
        try{
            categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){
            throw new NotFoundException("Id "+id+" not found");
        }
        catch (DataIntegrityViolationException ex){
            throw new DatabaseException("Database integrity violation");
        }
    }
}
