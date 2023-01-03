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
		 * join fectch indica que queremo juntar a conta com movimentações
		 * ou seja tirar o padrão lazy so tras as movimentações quando pedir ou dar o getMovimentações.
		 * Usando o join fetch ele ja traz as movimentações passando usando o padrão fetch
		 * Por padrão join fetch fara inner join que trará somente as contas que possuem movimentacão.
		 * Portanto, precisamos fazer um left join fetch em vez do join fetch 
		 * para trazer tudo esta do lado esquerdo do relacionamento ou seja trazer as contas mesmo que
		 * não tenha movimentação.
		 * Ao usar o distinct dizemos ao banco que queremos apenas os resultados
		 * diferentes. 
		 */
		String jpql ="select distinct c from Conta c left join fetch c.movimentacoes";
		
		Query query = em.createQuery(jpql);
				
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentações: " );
			for (Movimentacao m :conta.getMovimentacoes()) {
				System.out.println(m.getDescricao());
				
			}
		}
				
		em.getTransaction().commit();

		em.close();

	}

}
