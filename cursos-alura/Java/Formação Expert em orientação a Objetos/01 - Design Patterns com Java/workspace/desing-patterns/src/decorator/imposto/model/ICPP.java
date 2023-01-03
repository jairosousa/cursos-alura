package decorator.imposto.model;

import decorator.imposto.Imposto;
import strategy.imposto.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional {

	public ICPP() {
		super();
	}

	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

}
