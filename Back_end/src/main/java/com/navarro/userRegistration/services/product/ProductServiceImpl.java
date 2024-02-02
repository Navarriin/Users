package com.navarro.userRegistration.services.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.navarro.userRegistration.dtos.product.ProductDTO;
import com.navarro.userRegistration.dtos.product.mapper.ProductMapper;
import com.navarro.userRegistration.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream().map(productMapper::toDTO)
                .sorted((obj1, obj2) -> obj1.id().compareTo(obj2.id()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO body) {
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(body)));
    }
}
