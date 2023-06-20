package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.DTOConverter;
import com.jnsdev.backend.dto.product.ProductDTO;
import com.jnsdev.backend.exception.CategoryNotFoundException;
import com.jnsdev.backend.exception.ProductNotFoundException;
import com.jnsdev.backend.model.Category;
import com.jnsdev.backend.model.Product;
import com.jnsdev.backend.repository.CategoryRepository;
import com.jnsdev.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 05/01/2023 - 18:37
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(
            Long categoryId) {
        List<Product> products =
                productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return DTOConverter.convert(product);
        }
        throw new ProductNotFoundException();
    }

    public ProductDTO save(ProductDTO productDTO) {

        boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());

        if (!existsCategory) {
            throw new CategoryNotFoundException();
        }

        Product product = productRepository.save(Product.convert(productDTO));
        return DTOConverter.convert(product);
    }

    public void delete(Long productId) {
        Optional<Product> product =
                productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
        throw new ProductNotFoundException();
    }
}
