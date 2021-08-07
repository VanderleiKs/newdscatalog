package com.dscatalog.dtos;

import com.dscatalog.entities.Category;

public class CategoryDto {
    private long id;
    private String name;

    public CategoryDto(){
    }

    public CategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category dtoToCategory(CategoryDto cat){
        return new Category(cat.name);
    }
}
