package com.jnsdev.backend.controller;

import com.jnsdev.backend.dto.product.ProductDTO;
import com.jnsdev.backend.exception.ProductNotFoundException;
import com.jnsdev.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 05/01/2023 - 18:40
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();
        return produtos;
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> produtos =
                productService.getProductByCategoryId(categoryId);
        return produtos;
    }

    @GetMapping("/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) {
        return productService
                .findByProductIdentifier(productIdentifier);
    }

    @PostMapping()
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) throws ProductNotFoundException {
        productService.delete(id);
    }
}
