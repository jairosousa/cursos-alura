package br.com.alura.loja.imposto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:09
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class CalculadoraDeImpostos {

  /**
   * Padrão Stratgy
   *
   * @param orcamento
   * @param imposto
   * @return
   */
  public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {

    return imposto.calcular(orcamento);
  }

}
