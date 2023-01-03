package strategy.imposto.model;

import strategy.imposto.Orcamento;

public class ICMS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + 50.0;
	}

}
