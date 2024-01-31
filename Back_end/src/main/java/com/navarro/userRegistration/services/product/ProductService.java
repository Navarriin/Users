package com.navarro.userRegistration.services.product;

import com.navarro.userRegistration.models.product.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product createProduct(Product body);
}
