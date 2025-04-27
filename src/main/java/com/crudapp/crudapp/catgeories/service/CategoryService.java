package com.crudapp.crudapp.catgeories.service;

import org.springframework.http.ResponseEntity;

import com.crudapp.crudapp.catgeories.dto.ResponseBody;
import com.crudapp.crudapp.catgeories.entity.Category;

public interface CategoryService {
    ResponseEntity<ResponseBody> getAllCategories(int page);
    ResponseEntity<ResponseBody> getCategoryById(Long id);
    ResponseEntity<ResponseBody> createCategory(Category category);
    ResponseEntity<ResponseBody> updateCategory(Long id, Category category);
    ResponseEntity<ResponseBody> deleteCategory(Long id);

}
