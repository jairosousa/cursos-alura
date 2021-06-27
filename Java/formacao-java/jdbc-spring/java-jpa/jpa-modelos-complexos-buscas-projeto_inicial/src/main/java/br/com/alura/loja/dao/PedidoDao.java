package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;

public class PedidoDao {

  private final EntityManager em;

  public PedidoDao(EntityManager em) {
    this.em = em;
  }

  public void cadastrar(Pedido pedido) {
    this.em.persist(pedido);
  }

  public void atualizar(Pedido pedido) {
    this.em.merge(pedido);
  }

  public BigDecimal valorTotalVendido() {
    String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
    return this.em.createQuery(jpql, BigDecimal.class)
        .getSingleResult();
  }

  public Pedido buscarPorId(Long id) {
    return em.find(Pedido.class, id);
  }

  public List<Pedido> buscarTodos() {
    String jpql = "SELECT p FROM Pedido p";
    return em.createQuery(jpql, Pedido.class).getResultList();
  }

  public List<Pedido> buscarPorNomeCliente(String nome) {
    String jpql = "SELECT p FROM Pedido p WHERE p.cliente.nome = :nome";
    return em.createQuery(jpql, Pedido.class)
        .setParameter("nome", nome)
        .getResultList();
  }

  /*
  / Query Planejada
   */
  public Pedido buscaPedidoComCliente(Long id) {
    String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = ?1";
    return em.createQuery(jpql, Pedido.class)
        .setParameter(1, id)
        .getSingleResult();
  }

  public List<Pedido> buscarPorData(LocalDate data) {
    String jpql = "SELECT p FROM Pedido p WHERE p.data = :data";
    return em.createQuery(jpql, Pedido.class)
        .setParameter("data", data)
        .getResultList();
  }

  public List<RelatorioDeVendasVO> relatorioDeVendas() {
    String jpql =
        "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVO(produto.nome, SUM(item.quantidade), MAX(pedido.data)) "
            + "FROM Pedido pedido "
            + "JOIN pedido.itens item "
            + "JOIN item.produto produto "
            + "GROUP BY produto.nome "
            + "ORDER BY SUM(item.quantidade) DESC";

    return this.em.createQuery(jpql, RelatorioDeVendasVO.class)
        .getResultList();
  }

}
