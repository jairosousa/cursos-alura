package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public void atualizar(Pedido pedido) {
		this.em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = em.merge(pedido);
		this.em.remove(pedido);
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
	
	public List<Pedido> buscarPorData(LocalDate data) {
		String jpql = "SELECT p FROM Pedido p WHERE p.data = :data";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("data", data)
				.getResultList();
	}

}
