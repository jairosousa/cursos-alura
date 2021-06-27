package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}
	
	public void remover(Cliente cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);
	}

	public Cliente buscarPorId(long id) {
		return em.find(Cliente.class, id);
	}

	/**
	 * Busca Dinamica sem Criteria
	 * @param nome
	 * @param dataNascimento
	 * @return
	 */
	public List<Cliente> buscarClientes(String nome, LocalDate dataNascimento) {
		String jpql = "SELECT c FROM Cliente c WHERE 1=1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql += "AND c.nome = :nome ";
		}
		if (dataNascimento != null) {
			jpql += " AND c.dataNascimento = :dataNascimento ";
		}
		TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (dataNascimento != null) {
			query.setParameter("dataNascimento", dataNascimento);
		}
		return query.getResultList();
	}
}
