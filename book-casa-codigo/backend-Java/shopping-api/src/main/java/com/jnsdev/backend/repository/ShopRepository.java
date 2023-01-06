package com.jnsdev.backend.repository;

import com.jnsdev.backend.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 08:00
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {
    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);

//    @Query(value = "select s from Shop s where s.date >= :dataInicio")
    List<Shop> findAllByDateGreaterThanEqual(Date date);
}
