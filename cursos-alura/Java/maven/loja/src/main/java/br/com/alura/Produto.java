package br.com.alura;/*
 *
 * @Author: Jairo Nascimento on 21/06/2021 - 09:28
 *
 */

import java.math.BigDecimal;

public class Produto {

  private String nome;
  private BigDecimal valor;

  public Produto(String nome, BigDecimal valor) {
    this.nome = nome;
    this.valor = valor;
  }

  public String getNome() {
    return nome;
  }

  public BigDecimal getValor() {
    return valor;
  }
}
