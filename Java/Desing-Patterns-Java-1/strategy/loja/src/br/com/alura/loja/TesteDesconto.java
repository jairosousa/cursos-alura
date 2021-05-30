package br.com.alura.loja;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:16
 *
 */

import br.com.alura.loja.desconto.CalculadoraDesconto;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class TesteDesconto {

  public static void main(String[] args) {
    Orcamento primeiro = new Orcamento(new BigDecimal("200"), 6);
    Orcamento segundo = new Orcamento(new BigDecimal("1000"), 1);

    CalculadoraDesconto calculadora = new CalculadoraDesconto();

    System.out.println(calculadora.calcular(primeiro));
    System.out.println(calculadora.calcular(segundo));
  }

}
