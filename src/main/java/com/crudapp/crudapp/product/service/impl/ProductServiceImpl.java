package com.crudapp.crudapp.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crudapp.crudapp.catgeories.dto.CategoryDTO;
import com.crudapp.crudapp.catgeories.dto.ResponseBody;
import com.crudapp.crudapp.catgeories.repository.CategoryRepository;
import com.crudapp.crudapp.product.dto.ProductDTO;
import com.crudapp.crudapp.product.entity.Product;
import com.crudapp.crudapp.product.repository.ProductRepository;
import com.crudapp.crudapp.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public ResponseEntity<ResponseBody> getAllProducts(int page) {
        Page<Product> products = productRepo.findAll(PageRequest.of(page, 5));
         List<Product> productList = products.getContent();

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("products", productList);
        responseData.put("currentPage", products.getNumber());
        responseData.put("totalPages", products.getTotalPages());
        responseData.put("totalElements", products.getTotalElements());
        return ResponseEntity.ok(new ResponseBody("Fetched all products", true,  responseData));
    }

    @Override  //this will fetch the product by id and also fetch the category of that product
    public ResponseEntity<ResponseBody> getProductById(Long id) {
        return productRepo.findById(id)
                .map(product -> {
                    CategoryDTO categoryDTO = new CategoryDTO(
                            product.getCategory().getId(),
                            product.getCategory().getName()
                    );
                    ProductDTO productDTO = new ProductDTO(
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            categoryDTO
                    );
                    return ResponseEntity.ok(new ResponseBody("Product found", true, productDTO));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseBody("Product not found", false, null)));
    }


    @Override
    public ResponseEntity<ResponseBody> createProduct(Product product) {
        Product saved = productRepo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseBody("Product created successfully", true, saved));
    }

    @Override
    public ResponseEntity<ResponseBody> updateProduct(Long id, Product product) {
        return productRepo.findById(id)
                .map(existing -> {
                    existing.setName(product.getName());
                    existing.setPrice(product.getPrice());
                    existing.setCategory(product.getCategory());
                    Product updated = productRepo.save(existing);
                    return ResponseEntity.ok(new ResponseBody("Product updated successfully", true, updated));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseBody("Product not found", false, null)));
    }

    @Override
    public ResponseEntity<ResponseBody> deleteProduct(Long id) {
        return productRepo.findById(id)
                .map(existing -> {
                    productRepo.delete(existing);
                    return ResponseEntity.ok(new ResponseBody("Product deleted successfully", true, null));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseBody("Product not found", false, null)));
    }

}
