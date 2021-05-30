package br.com.alura.loja.orcamento;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:05
 *
 */

import java.math.BigDecimal;

public class Orcamento {

  private BigDecimal valor;
  private int quantidadeItens;
  private String situacao;

  public Orcamento(BigDecimal valor, int quantidadeItens) {
    this.valor = valor;
    this.quantidadeItens = quantidadeItens;
  }

  public void aplicarDescontoextra() {
    BigDecimal valordescontoExtra = BigDecimal.ZERO;
    if (situacao.equals("EM ANALISE")) {
      valordescontoExtra = this.valor.multiply(new BigDecimal("0.05"));
    } else if (situacao.equals("APROVADO")) {
      valordescontoExtra = this.valor.multiply(new BigDecimal("0.02"));
    }
    this.valor = this.valor.subtract(valordescontoExtra);
  }

  public void aprovar() {
    this.situacao = "APROVADO";
  }

  public BigDecimal getValor() {
    return valor;
  }

  public int getQuantidadeItens() {
    return quantidadeItens;
  }
}
