package br.com.alura.loja.pedido;/*
 * @Created 31/05/2021 - 16:49
 * @Projet loja
 * @Author jnasciso
 */

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoBancoDados;

import java.time.LocalDateTime;

/**
 * @Author: Jairo Nascimento on 31/05/2021 - 16:49
 */
public class GeraPedidoHandler {

  // Construtor com injeção de dependencias: repository, service, etc..

  public void execute(GeraPedido dados) {
    Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
    Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

    EnviarEmailPedido email = new EnviarEmailPedido();
    SalvarPedidoBancoDados salvar = new SalvarPedidoBancoDados();

    email.executar(pedido);
    salvar.executar(pedido);
  }

}
