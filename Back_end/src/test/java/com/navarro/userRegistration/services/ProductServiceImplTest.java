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
import java.util.List;

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
    void findAll() {
        when(mapper.toDTO(product)).thenReturn(productDTO);
        when(repository.findAll()).thenReturn(Collections.singletonList(product));

        var result = assertDoesNotThrow(() -> service.findAll());

        assertNotNull(result);
        assertEquals(1 ,result.size());
        assertEquals(Collections.singletonList(productDTO), result);
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTO(product);
    }
}