package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.product.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 13:38
 */
@Service
public class ProductService {

    public ProductDTO getProductByIdentifier(String productIdentifier) {
        RestTemplate restTemplate = new RestTemplate();
        String url =
                "http://localhost:8081/product/" + productIdentifier;
        ResponseEntity<ProductDTO> response =
                restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }
}
