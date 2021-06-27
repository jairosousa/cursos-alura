package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;
import javax.persistence.EntityManager;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 09:45
 */
public class ProdutoDao {

  private EntityManager em;

  public ProdutoDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Produto produto) {
    this.em.persist(produto);
  }
}
