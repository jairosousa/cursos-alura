package state.contabancaria;

public class Conta {

	protected double saldo;

	protected EstadoDaConta estado;

	public Conta() {
		this.estado = new Positivo();
	}

}
