package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaCount {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 2);

		String jpql = "select count(m) from Movimentacao m where m.conta = :pConta ";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);

		Long count= (Long) query.getSingleResult();

		System.out.println("O quantidade de movimentações para a conta é: " + count);

		em.getTransaction().commit();

		em.close();

	}

}
