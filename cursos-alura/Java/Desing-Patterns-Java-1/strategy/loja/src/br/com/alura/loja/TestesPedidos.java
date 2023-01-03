package br.com.alura.loja;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 16:11
 *
 */

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoBancoDados;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class TestesPedidos {

  public static void main(String[] args) {
    String cliente = "Jairo";
    BigDecimal valorOrcamento = new BigDecimal(100.0);
    int quantidadeItens = 5;

    GeraPedido gerador = new GeraPedido(cliente,valorOrcamento,quantidadeItens);
    GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(new SalvarPedidoBancoDados(), new EnviarEmailPedido()));
    handler.execute(gerador);

  }

}
