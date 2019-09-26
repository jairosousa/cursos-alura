package br.com.alura.bitebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SaldoInsuficienteExcepcion;

public class TestaBiblioteca {

	public static void main(String[] args) {

		Conta c = new ContaCorrente(222, 333);
		c.deposita(200.52);
		try {
			c.saca(500.0);
		} catch (SaldoInsuficienteExcepcion e) {
			System.out.println("Erro ao sacar: Saldo induficiente");
		}

		System.out.println("Saldo: " + c.getSaldo());

	}

}
