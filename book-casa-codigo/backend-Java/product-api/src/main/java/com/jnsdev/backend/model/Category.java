package com.jnsdev.backend.model;

import com.jnsdev.backend.dto.CategoryDTO;

import javax.persistence.*;

/**
 * @Autor Jairo Nascimento
 * @Created 05/01/2023 - 18:16
 */
@Entity(name="category")
@Table(name="category", schema = "products")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Category convert(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setNome(categoryDTO.getNome());
        return category;
    }
}
