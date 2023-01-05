package com.jnsdev.backend.dto;

import com.jnsdev.backend.model.Category;

/**
 * @Autor Jairo Nascimento
 * @Created 05/01/2023 - 18:22
 */
public class CategoryDTO {

    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}
