
public class TestaGerente {

	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Marcos");
		g1.setCpf("22.222.222-22");
		g1.setSalario(5000);
		
		System.out.println(g1.getNome());
		System.out.println(g1.getCpf());
		System.out.println(g1.getBonificacao());
		System.out.println(g1.autentica(222));
		
		g1.setSenha(222);
		System.out.println(g1.autentica(222));
	}

}
