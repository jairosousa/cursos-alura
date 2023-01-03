package br.com.alura;

/*
 *
 * @Author: Jairo Nascimento on 21/06/2021 - 09:31
 *
 */

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

  @Test
  public void testProduto() {
    Produto produto = new Produto("Teste", BigDecimal.TEN);
    Assert.assertEquals("Teste", produto.getNome());
    Assert.assertEquals(BigDecimal.TEN, produto.getValor());
  }

}