package com.crudapp.crudapp.catgeories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.crudapp.catgeories.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
