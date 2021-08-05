package com.dscatalog.controllers;

import com.dscatalog.entities.Category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryContoller {
    
    @GetMapping
    public ResponseEntity<Category> findAll(){
        return ResponseEntity.ok().body(new Category());
    } 
}
