
public class Administrador extends Funcionario implements Autenticavel {

	private int senha;
	
	//Composição
	private AutenticacaoUtil autenticador;

    public Administrador() {
    	//Composição
        this.autenticador = new AutenticacaoUtil();
    }

	@Override
	public double getBonificacao() {
		return 50;
	}

	@Override
    public void setSenha(int senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.autenticador.autentica(senha);
    }

}
