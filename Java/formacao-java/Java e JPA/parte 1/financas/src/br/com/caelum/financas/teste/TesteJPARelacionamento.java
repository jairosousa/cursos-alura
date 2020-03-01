package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("4252-8");
		conta.setBanco("341 - BANCO ITAÚ UNIBANCO");
		conta.setNumero("52698-0");
		conta.setTitular("Vasldomiro");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		
		movimentacao.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		em.persist(conta);//PRIMEIRO PERSISTIR A CONTA
		
		em.persist(movimentacao);
		
		em.getTransaction().commit();

		em.close();

	}

}
