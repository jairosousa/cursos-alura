package strategy.investimento;

import strategy.investimento.model.Conta;

public class RealizadorDeInvestimento {
	
	public void realizarInvestimento(Conta conta, Investimento investimento) {
		double lucro = investimento.calculaInvestimento(conta);
		
		conta.deposita(lucro * 0.75);
		
		System.out.println(String.format("Saldo conta %.2f, investimento %s", conta.getSaldo(), investimento.getClass().getSimpleName()));
	}

}
