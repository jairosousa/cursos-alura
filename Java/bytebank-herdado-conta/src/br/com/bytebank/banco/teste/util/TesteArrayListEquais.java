package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquais {

	public static void main(String[] args) {

		// Generics
		ArrayList<Conta> lista = new ArrayList();

		Conta cc1 = new ContaCorrente(22, 11);
		lista.add(cc1);

		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);

		Conta cc3 = new ContaCorrente(22, 22);

		boolean contem = lista.contains(cc3);

		System.out.println("Existe: " + contem);

		for (Conta conta : lista) {
			if (conta == cc3) {
				System.out.println("Já tem essa conta");
			}
		}
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}

	}

}
