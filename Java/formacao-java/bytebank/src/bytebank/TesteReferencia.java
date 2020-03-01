package bytebank;

public class TesteReferencia {

	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		Conta segundaConta = primeiraConta;
		
		System.out.println(segundaConta.saldo);
		
		primeiraConta.saldo = 500;
		System.out.println(segundaConta.saldo);

	}

}
