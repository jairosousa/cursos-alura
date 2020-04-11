package strategy.investimento.model;

import java.util.Random;

import strategy.investimento.Investimento;

public class Moderado implements Investimento {

	@Override
	public double calculaInvestimento(Conta conta) {
		
		int chance = new Random().nextInt(2);
		System.out.println("Chance Moderado: " + chance);
		
		if (chance == 0) {
			return conta.getSaldo() * 0.025;
		} else {
			return conta.getSaldo() * 0.07;
		}
	}

}
