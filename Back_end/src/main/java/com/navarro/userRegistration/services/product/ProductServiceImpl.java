package com.navarro.userRegistration.services.product;

import com.navarro.userRegistration.models.product.Product;
import com.navarro.userRegistration.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product createProduct(Product body) {
        return null;
    }
}
