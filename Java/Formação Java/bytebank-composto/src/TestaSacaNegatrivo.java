
public class TestaSacaNegatrivo {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.deposita(100);
		System.out.println(conta.saca(200));
		
//		 System.out.println(conta.saldo); Não compila
		
		// Proibido
//		conta.saldo = conta.saldo - 101;
//        System.out.println(conta.saldo);

		System.out.println(conta.getSaldo());
	}

}
