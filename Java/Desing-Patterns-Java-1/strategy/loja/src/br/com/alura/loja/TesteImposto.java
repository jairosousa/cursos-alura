package br.com.alura.loja;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:16
 *
 */

import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public class TesteImposto {

  public static void main(String[] args) {
    Orcamento orcamento = new Orcamento(new BigDecimal("100"));

    CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();

    System.out.println(calculadora.calcular(orcamento, new ISS()));
  }

}
