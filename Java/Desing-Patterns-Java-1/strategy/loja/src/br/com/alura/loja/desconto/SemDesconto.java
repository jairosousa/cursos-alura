package br.com.alura.loja.desconto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 12:02
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class SemDesconto extends Desconto {

  public SemDesconto() {
    super(null);
  }

  @Override
  public BigDecimal efetuarCalculo(Orcamento orcamento) {
    return BigDecimal.ZERO;
  }

  @Override
  public boolean deveAplicar(Orcamento orcamento) {
    return true;
  }
}
