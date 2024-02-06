package com.navarro.userRegistration.dtos.product.mapper;

import org.springframework.stereotype.Component;

import com.navarro.userRegistration.dtos.product.ProductDTO;
import com.navarro.userRegistration.models.product.Product;

import java.util.Objects;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        if(Objects.isNull(product)) return null;

        return new ProductDTO(product);
    }

    public Product toEntity(ProductDTO body) {
        if(Objects.isNull(body)) return null;

        Product product = new Product();
        if(Objects.nonNull(body.id())) product.setId(body.id());

        product.setName(body.name());
        product.setPrice(body.price());
        return product;
    }

}
