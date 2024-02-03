package com.navarro.userRegistration.services.product;

import java.util.List;

import com.navarro.userRegistration.dtos.product.ProductDTO;

public interface ProductService {

    public List<ProductDTO> findAll();

    public ProductDTO createProduct(ProductDTO body);

    public void deleteProduct(String id);

}
