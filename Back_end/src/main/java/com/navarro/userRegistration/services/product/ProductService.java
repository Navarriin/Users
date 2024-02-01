package com.navarro.userRegistration.services.product;

import com.navarro.userRegistration.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> findAll();
    public ProductDTO createProduct(ProductDTO body);
}
