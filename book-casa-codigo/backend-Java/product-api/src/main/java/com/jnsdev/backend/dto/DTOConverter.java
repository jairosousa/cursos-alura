package com.jnsdev.backend.dto;

import com.jnsdev.backend.dto.product.CategoryDTO;
import com.jnsdev.backend.dto.product.ProductDTO;
import com.jnsdev.backend.model.Category;
import com.jnsdev.backend.model.Product;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 12:23
 */
public class DTOConverter {

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setProductIdentifier(
                product.getProductIdentifier());
        if (product.getCategory() != null) {
            productDTO.setCategory(
                    DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }
}
