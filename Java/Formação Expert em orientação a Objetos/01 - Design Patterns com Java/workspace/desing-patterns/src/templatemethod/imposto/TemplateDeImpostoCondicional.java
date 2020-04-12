package templatemethod.imposto;

import strategy.imposto.Orcamento;
import strategy.imposto.model.Imposto;

public abstract class TemplateDeImpostoCondicional implements Imposto {

	@Override
	public final double calcula(Orcamento orcamento) {// usa final para evitar que as classes filhas altere a assinatura do método.

		if (deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	protected  abstract double minimaTaxacao(Orcamento orcamento);

	protected  abstract double maximaTaxacao(Orcamento orcamento);

	protected  abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);
}
