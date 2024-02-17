package com.navarro.userRegistration.services;

import com.navarro.userRegistration.dtos.product.ProductDTO;
import com.navarro.userRegistration.dtos.product.mapper.ProductMapper;
import com.navarro.userRegistration.models.product.Product;
import com.navarro.userRegistration.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class ProductServiceImplTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductServiceImpl service;

    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.product = new Product("uuiasd-22a", "Mouse teste", 22);
        this.productDTO = new ProductDTO("uuiasd-22a", "Mouse teste", 22);
    }

    @Test
    void findAllSuccess() {
        when(mapper.toDTO(product)).thenReturn(productDTO);
        when(repository.findAll()).thenReturn(Collections.singletonList(product));

        var result = assertDoesNotThrow(() -> service.findAll());

        assertNotNull(result);
        assertEquals(1 ,result.size());
        assertEquals(Collections.singletonList(productDTO), result);
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTO(product);
    }

    @Test
    void getProductByIdSuccess() {
        when(mapper.toDTO(product)).thenReturn(productDTO);
        when(repository.findById(product.getId())).thenReturn(Optional.ofNullable(product));

        var result = assertDoesNotThrow(() -> service.getProductById(product.getId()));

        assertNotNull(result);
        assertEquals(productDTO, result);
        verify(repository, times(1)).findById(product.getId());
        verify(mapper, times(1)).toDTO(product);
    }

    @Test
    void getProductByIdError() {
        when(mapper.toDTO(product)).thenReturn(productDTO);
        when(repository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> service.getProductById(any()));
    }

    /*
       @Override
    public ProductDTO getProductById(String id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(NullPointerException::new);
    }
     */
}