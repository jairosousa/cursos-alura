package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import javax.persistence.EntityManager;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 09:45
 */
public class CategoriaDao {

  private EntityManager em;

  public CategoriaDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Categoria categoria) {
    this.em.persist(categoria);
  }
}
