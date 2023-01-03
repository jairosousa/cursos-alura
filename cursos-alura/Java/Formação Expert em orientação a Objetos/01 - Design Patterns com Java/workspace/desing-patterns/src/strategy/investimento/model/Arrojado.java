package strategy.investimento.model;

import java.util.Random;

import strategy.investimento.Investimento;

public class Arrojado implements Investimento {

	@Override
	public double calculaInvestimento(Conta conta) {
		int chute = new Random().nextInt(10);
		System.out.println("Chute Arrojado: " + chute);

		if (chute >= 0 && chute <= 1) {
			return conta.getSaldo() * 0.05;
		} else if (chute >= 2 && chute <=4) {
			return conta.getSaldo() * 0.03;
		} else {
			return conta.getSaldo() * 0.06;
		}
	}

}
