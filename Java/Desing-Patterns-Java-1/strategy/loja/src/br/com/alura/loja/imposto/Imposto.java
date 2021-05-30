package br.com.alura.loja.imposto;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 11:25
 *
 */

import br.com.alura.loja.orcamento.Orcamento;
import java.math.BigDecimal;

public interface Imposto {

  BigDecimal calcular(Orcamento orcamento);

}
