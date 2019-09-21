
public class Gerente extends Funcionario {

	private int senha;

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	@Override
	public double getBonificacao() {
		System.out.println("Chamando o metodo getBonificacao do GERENTE");
		return super.getBonificacao() + super.getSalario();
	}

}
