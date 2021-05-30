package br.com.alura.loja.orcamento;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:05
 *
 */

import java.math.BigDecimal;

public class Orcamento {

  private BigDecimal valor;

  public Orcamento(BigDecimal valor) {
    this.valor = valor;
  }
  public BigDecimal getValor() {
    return valor;
  }
}
