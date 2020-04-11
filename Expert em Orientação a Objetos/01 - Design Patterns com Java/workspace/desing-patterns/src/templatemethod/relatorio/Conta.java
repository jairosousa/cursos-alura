package templatemethod.relatorio;

public class Conta {

	private String nome;

	private String agencia;

	private String numero;
	
	private double saldo;

	public Conta(String nome, String agencia, String numero, double saldo) {
		this.nome = nome;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

}
