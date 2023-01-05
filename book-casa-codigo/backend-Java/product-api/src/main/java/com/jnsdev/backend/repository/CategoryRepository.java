package com.jnsdev.backend.repository;

import com.jnsdev.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 05/01/2023 - 18:34
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
