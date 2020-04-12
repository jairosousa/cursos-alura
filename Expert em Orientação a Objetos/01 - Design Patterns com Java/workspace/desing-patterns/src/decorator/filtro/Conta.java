package decorator.filtro;

import java.util.Calendar;

public class Conta {

	private double valor;

	private Calendar dataAbertura;

	public Conta(double valor, Calendar dataAbertura) {
		this.valor = valor;
		this.dataAbertura = dataAbertura;
	}

	public double getValor() {
		return valor;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

}
