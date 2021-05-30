package br.com.alura.loja.desconto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:35
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class CalculadoraDesconto {

  /**
   * Padrão Chain of Responsibility
   *
   * @param orcamento
   * @return
   */
  public BigDecimal calcular(Orcamento orcamento) {
    Desconto cadeiaDesconto =
        new DescontoOrcamentoComMaisDeCincoItens(
            new DescontoOrcamentoComValorMaiorQuinhentos(
                new SemDesconto()));

    return cadeiaDesconto.calcular(orcamento);
  }

}
