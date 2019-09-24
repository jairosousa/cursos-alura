
public class TestaConta {

	public static void main(String[] args) throws SaldoInsuficienteExcepcion {// s� para deixar compilando o ideal era try/catch

		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100);

		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200);

		cc.transfere(10, cp);

		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
		
		// Lembrando � sempre chamado o metodo mais especifico.
		// o metodo saca e chamdo da class Conta Corrente;

	}

}
