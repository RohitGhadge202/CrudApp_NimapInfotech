package com.crudapp.crudapp.product.dto;

import com.crudapp.crudapp.catgeories.dto.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private CategoryDTO category;

}
