package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArraysReferencias {

	public static void main(String[] args) {

		Object[] refs = new Object[5];

		ContaCorrente cc1 = new ContaCorrente(22, 11);

		refs[0] = cc1;
		
		ContaPoupanca cp1 = new ContaPoupanca(22, 22);
		
		refs[1] = cp1;
		
		Cliente c = new Cliente();
		refs[2] = c;
		
//		System.out.println(refs[1].getNumero());
		
		ContaPoupanca ref = (ContaPoupanca) refs[1];
		
		System.out.println(cc1.getNumero());
		System.out.println(ref.getNumero());

	}

}
