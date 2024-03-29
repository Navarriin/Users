package com.navarro.userRegistration.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.navarro.userRegistration.dtos.product.ProductDTO;
import com.navarro.userRegistration.dtos.product.mapper.ProductMapper;
import com.navarro.userRegistration.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream().map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(String id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public ProductDTO createProduct(ProductDTO body) {
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(body)));
    }
}
