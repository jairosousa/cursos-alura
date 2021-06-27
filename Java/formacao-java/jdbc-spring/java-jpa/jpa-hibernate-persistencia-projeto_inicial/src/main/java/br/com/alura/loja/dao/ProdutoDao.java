package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
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

  public Produto buscaPorId(Long id) {
    return this.em.find(Produto.class, id);
  }

  public List<Produto> buscaTodos() {
    String jpql = "SELECT p FROM Produto p";
    return this.em.createQuery(jpql, Produto.class).getResultList();
  }

  public List<Produto> buscaPorNome(String nome) {
    String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
    return this.em.createQuery(jpql, Produto.class)
        .setParameter("nome", nome)
        .getResultList();
  }

  public List<Produto> buscaPorNomeDaCategoria(String nome) {
    String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
    return this.em.createQuery(jpql, Produto.class)
        .setParameter("nome", nome)
        .getResultList();
  }

  public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
    String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
    return this.em.createQuery(jpql, BigDecimal.class)
        .setParameter("nome", nome)
        .getSingleResult();
  }
}
