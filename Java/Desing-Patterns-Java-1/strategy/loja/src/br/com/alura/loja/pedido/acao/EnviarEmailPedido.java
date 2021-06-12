package br.com.alura.loja.pedido.acao;/*
 * @Created 31/05/2021 - 17:08
 * @Projet loja
 * @Author jnasciso
 */

import br.com.alura.loja.pedido.Pedido;

/**
 * @Author: Jairo Nascimento on 31/05/2021 - 17:08
 */
public class EnviarEmailPedido implements AcaoAposGerarPedido {

  public void executarAcao(Pedido pedido) {
    System.out.println("Enviando email com dados do pedido!");
  }

}
