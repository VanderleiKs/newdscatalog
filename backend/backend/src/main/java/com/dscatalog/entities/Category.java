package com.dscatalog.entities;

import com.dscatalog.dtos.CategoryDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String name;

     public Category(){}

     public Category(String name){
         this.name = name;
     }

     public Category(CategoryDto dto){
         this.name = dto.getName();
     }

     public long getId(){
         return id;
     }

     public String getName(){
         return name;
     }

     public void setName(String name){
         this.name = name;
     }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (id != other.id)
            return false;
        return true;
    }
}