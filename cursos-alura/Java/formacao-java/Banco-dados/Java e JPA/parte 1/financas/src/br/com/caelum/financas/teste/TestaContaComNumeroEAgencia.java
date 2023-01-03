package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaContaComNumeroEAgencia {

	private String conta;
	private String agencia;

	public TestaContaComNumeroEAgencia(String conta, String agencia) {
		super();
		this.conta = conta;
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		
		List<TestaContaComNumeroEAgencia> contas = em.createQuery("select new br.com.caelum.financas.teste.TestaContaComNumeroeAgencia(c.numero, c.agencia) "
				+ "from Conta c").getResultList();
		
		for (TestaContaComNumeroEAgencia conta : contas) {
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Conta: " + conta.getConta());
		}
		
		em.getTransaction().commit();

		em.close();

	}

}
