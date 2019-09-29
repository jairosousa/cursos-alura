package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {

		// Generics
		List<Conta> lista = new ArrayList();
//		Collection<Conta> lista = new ArrayList();

//		List<Conta> lista = new Vector<Conta>(); //thread safe
		
		Cliente c = new Cliente();
//		lista.add(c); nem compila

		Conta cc1 = new ContaCorrente(22, 11);
		lista.add(cc1);

		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);

		System.out.println(lista.size());

		Conta ref = lista.get(0);
		System.out.println(ref.getNumero());

		lista.remove(0);
		System.out.println(lista.size());

		Conta cc3 = new ContaCorrente(22, 33);
		lista.add(cc1);

		Conta cc4 = new ContaCorrente(22, 44);
		lista.add(cc2);

		for (int i = 0; i < lista.size(); i++) {
			Object oRef = lista.get(i);
			System.out.println(oRef);
		}
		
		System.out.println("==========================");
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}

	}

}
