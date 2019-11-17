package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(1);

//		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		TypedQuery<Double> typtQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		typtQuery.setParameter("pConta", conta);
		typtQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typtQuery.getResultList();

		for (Double media : medias) {
			System.out.println("A medias são: " + media);
		}

		em.getTransaction().commit();

		em.close();
	}

}
