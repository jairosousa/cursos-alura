package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);
		
		conta.setTitular("Jairo Nascimento");
		
		conta.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		
		conta.setNumero("45632-8");
		
		conta.setAgencia("5362");
		
		em.getTransaction().commit();
		
		em.close();
		
		
		System.out.println(conta.getTitular());
	}

}
