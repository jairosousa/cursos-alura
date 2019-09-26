package br.com.bytebank.banco.modelo;
public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}

	/**
	 * Nova regra de saque para CC Cobra-se taxa de 20 centavos
	 * @throws SaldoInsuficienteExcepcion 
	 */
	@Override
	public void saca(double valor) throws SaldoInsuficienteExcepcion {
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public double getValorImposto() {
		return super.getSaldo() * 0.01;
	}

}
