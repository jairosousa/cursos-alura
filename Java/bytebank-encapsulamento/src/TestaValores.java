
public class TestaValores {

	public static void main(String[] args) {

		Conta conta = new Conta(1337, 24226);
		Conta conta1 = new Conta(1337, 24226);
		Conta conta2 = new Conta(1337, 24226);
		Conta conta3 = new Conta(1337, 24226);
		Conta conta4 = new Conta(1337, 24226);

		// a conta inconsistencia
		conta.setAgencia(-50);
		conta.setNumero(-100);

		System.out.println(conta.getAgencia());
		System.out.println(Conta.getTotal());

	}

}
