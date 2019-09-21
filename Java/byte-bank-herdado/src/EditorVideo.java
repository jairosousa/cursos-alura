
public class EditorVideo extends Funcionario {

	@Override
	public double getBonificacao() {
		System.out.println("Chamando o metodo getBonificacao do EDITOR VIDEO");
		return super.getBonificacao() + 100;
	}

}
