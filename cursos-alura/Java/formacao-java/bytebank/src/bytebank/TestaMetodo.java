package bytebank;

public class TestaMetodo {
	public static void main(String[] args) {
		Conta ContaDoPaulo = new Conta();
		ContaDoPaulo.deposita(50);
		System.out.println(ContaDoPaulo.saldo);
		
		boolean conseguiuSacar = ContaDoPaulo.saca(20);
		System.out.println(ContaDoPaulo.saldo);
		System.out.println(conseguiuSacar);
		
		Conta contaDaMarcela = new Conta();
		contaDaMarcela.saldo = 1000;
		
		if(contaDaMarcela.transfere(1200, ContaDoPaulo))
			System.out.println("Transferencia com sucesso");
			else System.out.println("Faltou dinheiro");
		
		System.out.println(ContaDoPaulo.saldo);
		System.out.println(contaDaMarcela.saldo);
	}
}
