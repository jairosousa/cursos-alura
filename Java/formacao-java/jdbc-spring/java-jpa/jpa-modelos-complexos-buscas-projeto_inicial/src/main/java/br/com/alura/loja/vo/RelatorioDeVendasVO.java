package br.com.alura.loja.vo;

import java.time.LocalDate;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 17:43
 */
public class RelatorioDeVendasVO {

  private String nomeProduto;
  private Long quantidadeVendida;
  private LocalDate dataUltimaVenda;

  public RelatorioDeVendasVO(String nomeProduto, Long quantidadeVendida,
      LocalDate dataUltimaVenda) {
    this.nomeProduto = nomeProduto;
    this.quantidadeVendida = quantidadeVendida;
    this.dataUltimaVenda = dataUltimaVenda;
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public Long getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public LocalDate getDataUltimaVenda() {
    return dataUltimaVenda;
  }
}
