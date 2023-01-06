package com.jnsdev.backend.repository;

import com.jnsdev.backend.dto.ShopReportDTO;
import com.jnsdev.backend.model.Shop;

import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 09:33
 */
public interface ReportRepository {

    List<Shop> getShopByFilters(
            Date dataInicio,
            Date dataFim,
            Float valorMinimo);

    ShopReportDTO getReportByDate(
            Date dataInicio,
            Date dataFim);
}

