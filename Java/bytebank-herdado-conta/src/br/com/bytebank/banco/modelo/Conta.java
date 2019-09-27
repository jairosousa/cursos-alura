package br.com.bytebank.banco.modelo;

/**
 * Classe que representa a moldura de Conta
 * 
 * @author Jairo Nascimento
 *
 */
public abstract class Conta {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;

	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e número.
	 * 
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero) {
		Conta.total++;
//		System.out.println("total de contas é: " + total);
		this.agencia = agencia;
		this.numero = numero;
//		System.out.println("estou criando uma conta: " + numero);
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	/**
	 * Valor deve ser maio do que o saldo.
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteExcepcion
	 */
	public void saca(double valor) throws SaldoInsuficienteExcepcion {
		if (this.saldo < valor) {
			// Problema
			throw new SaldoInsuficienteExcepcion("Saldo: " + this.saldo + ", valor: " + valor);
		}

		this.saldo -= valor;
	}

	public void transfere(double valor, Conta destino) throws SaldoInsuficienteExcepcion {
		this.saca(valor);
		destino.deposita(valor);
	}

	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("não pode valor menor ou igual a zero");
			return;
		}

		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("não pode valor menor ou igual a zero");
			return;
		}
		this.numero = numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public static int getTotal() {
		return Conta.total;
	}

	@Override
	public String toString() {
		return "Numero: " + this.numero + ", Agencia:" + this.agencia;
	}
}
