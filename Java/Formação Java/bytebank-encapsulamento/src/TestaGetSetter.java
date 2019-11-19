
public class TestaGetSetter {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta(1337, 24226);
		
//		conta.setNumero(1331);
		System.out.println(conta.getNumero());
		
		Cliente paulo = new Cliente();
		paulo.setNome("Paulo Silveira");
		
		conta.setTitular(paulo);
		
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("Programador");
		
		System.out.println(paulo.getProfissao());
		System.out.println(conta.getTitular().getProfissao());
	}

}
