package br.com.alura.loja.orcamento.situacao;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 15:33
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class Aprovado extends SituacaoOrcamento{

  public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
    return orcamento.getValor().multiply(new BigDecimal("0.02"));
  }

  @Override
  public void finalizar(Orcamento orcamento) {
    orcamento.setSituacao(new Finalizado());
  }
}
