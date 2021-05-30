package br.com.alura.loja;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 16:11
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.Pedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestesPedidos {

  public static void main(String[] args) {
    Orcamento orcamento = new Orcamento(new BigDecimal("600"), 4);
    String cliente = "Ana da Silva";
    LocalDateTime data = LocalDateTime.now();

    Pedido pedido = new Pedido(cliente, data, orcamento);

    System.out.println("Salvar pedido no banco de dados");
    System.out.println("Enviar email com dados de novo pedido");

  }

}
