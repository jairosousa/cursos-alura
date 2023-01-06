package com.jnsdev.backend.dto;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 09:31
 */
public class ShopReportDTO {
    private Integer count;
    private Double total;
    private Double mean;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }
}
