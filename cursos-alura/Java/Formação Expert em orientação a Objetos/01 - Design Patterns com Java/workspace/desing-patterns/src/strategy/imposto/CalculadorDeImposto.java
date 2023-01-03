package strategy.imposto;

import strategy.imposto.model.Imposto;

public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);
		System.out.println(String.format("Imposto %s: %.2f",imposto.getClass().getSimpleName(), valor));

	}

}
