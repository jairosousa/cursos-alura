package br.com.bytebank.banco.teste;

public class TestaConta {

	public static void main(String[] args) throws br.com.bytebank.banco.modelo.SaldoInsuficienteExcepcion {// só para deixar compilando o ideal era try/catch

		// Full Qualified Name FQN
		br.com.bytebank.banco.modelo.ContaCorrente cc = new br.com.bytebank.banco.modelo.ContaCorrente(111, 111);
		cc.deposita(100);

		br.com.bytebank.banco.modelo.ContaPoupanca cp = new br.com.bytebank.banco.modelo.ContaPoupanca(222, 222);
		cp.deposita(200);

		cc.transfere(10, cp);

		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
		
		// Lembrando é sempre chamado o metodo mais especifico.
		// o metodo saca e chamdo da class Conta Corrente;

	}

}
