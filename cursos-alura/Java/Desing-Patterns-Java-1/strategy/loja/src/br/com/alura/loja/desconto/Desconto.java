package br.com.alura.loja.desconto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 12:09
 *
 * Aplicado Padrão Template Method
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public abstract class Desconto {

  protected Desconto proximo;

  public Desconto(Desconto proximo) {
    this.proximo = proximo;
  }

  public BigDecimal calcular(Orcamento orcamento) {
    if (deveAplicar(orcamento)) {
      return efetuarCalculo(orcamento);
    }
    return proximo.calcular(orcamento);
  }

  protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

  protected abstract boolean deveAplicar(Orcamento orcamento);

}
