package decorator.imposto.model;

import decorator.imposto.Imposto;
import strategy.imposto.Orcamento;

public class ImpostoMuitoAlto extends Imposto {

	public ImpostoMuitoAlto() {
		super();
	}

	public ImpostoMuitoAlto(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.2 + calculoDoOutroImposto(orcamento);
	}

}
