package br.com.alura.loja.desconto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 12:02
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class DescontoOrcamentoComValorMaiorQuinhentos extends Desconto{

  public DescontoOrcamentoComValorMaiorQuinhentos(Desconto proximo) {
    super(proximo);
  }

  public BigDecimal calcular(Orcamento orcamento) {

    if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
      return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    return proximo.calcular(orcamento);
  }
}
