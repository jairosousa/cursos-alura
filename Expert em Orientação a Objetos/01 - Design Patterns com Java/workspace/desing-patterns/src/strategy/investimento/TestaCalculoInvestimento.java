package strategy.investimento;

import strategy.investimento.model.Arrojado;
import strategy.investimento.model.Conservador;
import strategy.investimento.model.Conta;
import strategy.investimento.model.Moderado;

public class TestaCalculoInvestimento {

	public static void main(String[] args) {
		Conta conta = new Conta(500.0);

		Investimento conservador = new Conservador();
		Investimento moderado = new Moderado();
		Investimento arrojado = new Arrojado();
		
		RealizadorDeInvestimento rdi = new RealizadorDeInvestimento();
		
		rdi.realizarInvestimento(conta, conservador);
		rdi.realizarInvestimento(conta, moderado);
		rdi.realizarInvestimento(conta, arrojado);
	}

}
