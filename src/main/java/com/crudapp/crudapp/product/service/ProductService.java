package com.crudapp.crudapp.product.service;

import org.springframework.http.ResponseEntity;

import com.crudapp.crudapp.catgeories.dto.ResponseBody;
import com.crudapp.crudapp.product.entity.Product;

public interface ProductService {
     ResponseEntity<ResponseBody> getAllProducts(int page);
    ResponseEntity<ResponseBody> getProductById(Long id);
    ResponseEntity<ResponseBody> createProduct(Product product);
    ResponseEntity<ResponseBody> updateProduct(Long id, Product product);
    ResponseEntity<ResponseBody> deleteProduct(Long id);

}
