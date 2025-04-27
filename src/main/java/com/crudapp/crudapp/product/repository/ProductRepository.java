package com.crudapp.crudapp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.crudapp.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    

}
