package br.com.alura.loja.imposto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:22
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class ISS implements Imposto{

  public BigDecimal calcular(Orcamento orcamento) {
    return orcamento.getValor().multiply(new BigDecimal("0.06"));
  }
}
