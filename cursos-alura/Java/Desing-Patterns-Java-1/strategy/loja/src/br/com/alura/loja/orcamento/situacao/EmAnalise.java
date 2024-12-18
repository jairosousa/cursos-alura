package br.com.alura.loja.orcamento.situacao;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 15:33
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class EmAnalise extends SituacaoOrcamento{

  public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
    return orcamento.getValor().multiply(new BigDecimal("0.05"));
  }

  public void aprovar(Orcamento orcamento) {
    orcamento.setSituacao(new Aprovado());
  }

  public void reprovar(Orcamento orcamento) {
    orcamento.setSituacao(new Reprovado());
  }

}
