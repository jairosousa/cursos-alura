package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class TesteGuardadorDeContas {

	public static void main(String[] args) {

		GuardadorDeContas guardador = new GuardadorDeContas();

		Conta cc1 = new ContaCorrente(22, 11);

		guardador.adiciona(cc1);

		Conta cc2 = new ContaCorrente(22, 22);

		guardador.adiciona(cc2);

		int tamanho = guardador.getQuantidadeDeElementos();

		System.out.println(tamanho);

		Conta ref = guardador.getReferencia(0);

		System.out.println(ref.getNumero());

	}

}
