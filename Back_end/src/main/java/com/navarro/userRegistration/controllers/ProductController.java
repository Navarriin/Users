package com.navarro.userRegistration.controllers;

import com.navarro.userRegistration.dtos.ProductDTO;
import com.navarro.userRegistration.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO body) {
        return ResponseEntity.ok().body(productService.createProduct(body));
    }
}
