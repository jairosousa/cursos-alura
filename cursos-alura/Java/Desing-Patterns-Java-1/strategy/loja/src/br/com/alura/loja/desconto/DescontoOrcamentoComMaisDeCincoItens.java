package br.com.alura.loja.desconto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 12:02
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class DescontoOrcamentoComMaisDeCincoItens extends Desconto {

  public DescontoOrcamentoComMaisDeCincoItens(Desconto proximo) {
    super(proximo);
  }

  public BigDecimal efetuarCalculo(Orcamento orcamento) {

    return orcamento.getValor().multiply(new BigDecimal("0.1"));

  }

  @Override
  public boolean deveAplicar(Orcamento orcamento) {
    return orcamento.getQuantidadeItens() > 5;
  }
}
