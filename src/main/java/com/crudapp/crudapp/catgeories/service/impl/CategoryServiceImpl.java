package com.crudapp.crudapp.catgeories.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crudapp.crudapp.catgeories.dto.ResponseBody;
import com.crudapp.crudapp.catgeories.entity.Category;
import com.crudapp.crudapp.catgeories.repository.CategoryRepository;
import com.crudapp.crudapp.catgeories.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public ResponseEntity<ResponseBody> getAllCategories(int page) {
     
        Page<Category> categories = categoryRepo.findAll(PageRequest.of(page, 5));
        List<Category> categoryList = categories.getContent();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("categories", categoryList);
        responseData.put("currentPage", categories.getNumber());
        responseData.put("totalPages", categories.getTotalPages());
        responseData.put("totalElements", categories.getTotalElements());
        return ResponseEntity.ok(new ResponseBody("Fetched all categories", true, responseData));
    }

    @Override
    public ResponseEntity<ResponseBody> getCategoryById(Long id) {
        return categoryRepo.findById(id)
                .map(category -> ResponseEntity.ok(new ResponseBody("Category found", true, category)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseBody("Category not found", false, null)));
    }

    @Override
    public ResponseEntity<ResponseBody> createCategory(Category category) {
        Category saved = categoryRepo.save(category);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseBody("Category created successfully", true, saved));
    }

    @Override
    public ResponseEntity<ResponseBody> updateCategory(Long id, Category category) {
        return categoryRepo.findById(id)
                .map(existing -> {
                    existing.setName(category.getName());
                    Category updated = categoryRepo.save(existing);
                    return ResponseEntity.ok(new ResponseBody("Category updated successfully", true, updated));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseBody("Category not found", false, null)));
    }

    @Override
    public ResponseEntity<ResponseBody> deleteCategory(Long id) {
        return categoryRepo.findById(id)
                .map(existing -> {
                    categoryRepo.delete(existing);
                    return ResponseEntity.ok(new ResponseBody("Category deleted successfully", true, null));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseBody("Category not found", false, null)));
    }

}
