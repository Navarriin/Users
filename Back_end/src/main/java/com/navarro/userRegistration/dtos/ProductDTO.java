package com.navarro.userRegistration.dtos;

import com.navarro.userRegistration.models.product.Product;

public record ProductDTO(String id, String name, Integer price) {

    public ProductDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());
    }
}
