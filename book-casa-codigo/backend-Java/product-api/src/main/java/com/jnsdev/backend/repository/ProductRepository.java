package com.jnsdev.backend.repository;

import com.jnsdev.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 05/01/2023 - 18:34
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "SELECT p FROM Product p " +
            "JOIN category c on p.category.id = c.id " +
            "WHERE  c.id = :categoryId")
    List<Product> getProductByCategory(@Param("categoryId") Long categoryId);

    Product findByProductIdentifier(String productIdentifier);
}
