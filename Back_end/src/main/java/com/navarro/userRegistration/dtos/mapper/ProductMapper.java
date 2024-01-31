package com.navarro.userRegistration.dtos.mapper;

import com.navarro.userRegistration.dtos.ProductDTO;
import com.navarro.userRegistration.models.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        if(product == null) return null;

        return new ProductDTO(product);
    }

    public Product toEntity(ProductDTO body) {
        if(body == null) return null;

        Product product = new Product();
        if(body.id() != null) product.setId(body.id());

        product.setName(body.name());
        product.setPrice(body.price());
        return product;
    }

}
