package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasMovimentacoesDasConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		/**
		 * join fectch indica que queremo juntar a conta com movimenta��es
		 * ou seja tirar o padr�o lazy so tras as movimenta��es quando pedir ou dar o getMovimenta��es
		 * usando o join fetch ele ja traz as movimenta��es passando usando o padr�o fetch
		 * left join pede trazer tudo esta do lado esquerdo do relacionamento ou seja trazer
		 * as contas mesmo que n�o tenga movimenta��o
		 */
		String jpql ="select distinct c from Conta c left join fetch c.movimentacoes";
		
		Query query = em.createQuery(jpql);
				
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimenta��es: " );
			for (Movimentacao m :conta.getMovimentacoes()) {
				System.out.println(m.getDescricao());
				
			}
		}
				
		em.getTransaction().commit();

		em.close();

	}

}
