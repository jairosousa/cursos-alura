package br.com.alura.loja.orcamento.situacao;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 15:33
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class Reprovado extends SituacaoOrcamento{

  @Override
  public void finalizar(Orcamento orcamento) {
    orcamento.setSituacao(new Finalizado());
  }
}
