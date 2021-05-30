package br.com.alura.loja.desconto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:35
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class CalculadoraDesconto {

  public BigDecimal calcular(Orcamento orcamento) {
    if (orcamento.getQuantidadeItens() > 5) {
      return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
    if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
      return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
    return BigDecimal.ZERO;
  }

}
