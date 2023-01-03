package chainofresponsibility.descontos.model;

import chainofresponsibility.descontos.Desconto;
import strategy.imposto.Orcamento;

/**
 * Calcula desconto com mais de cinco itens na lista
 * 
 * @author jnsousa
 *
 */
public class DescontoPorMaisDeCincoItens implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} else
			return proximo.desconta(orcamento);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
