package decorator.imposto;

import strategy.imposto.Orcamento;

public abstract class Imposto {

	protected final Imposto outroImposto;

	// construtor default
	public Imposto() {
		this.outroImposto = null;
	}

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	public abstract double calcula(Orcamento orcamento);

	protected double calculoDoOutroImposto(Orcamento orcamento) {
		// tratando o caso do proximo imposto nao existir!
		if (outroImposto == null)
			return 0;
		return outroImposto.calcula(orcamento);
	}

}
