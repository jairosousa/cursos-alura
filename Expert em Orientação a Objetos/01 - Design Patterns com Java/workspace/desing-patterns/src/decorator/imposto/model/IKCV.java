package decorator.imposto.model;

import decorator.imposto.Imposto;
import strategy.imposto.Item;
import strategy.imposto.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {
	
	public IKCV() {
		super();
	}

	public IKCV(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	protected  double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	protected  double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	protected  boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento);
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() > 100)
				return true;
		}

		return false;
	}

}
