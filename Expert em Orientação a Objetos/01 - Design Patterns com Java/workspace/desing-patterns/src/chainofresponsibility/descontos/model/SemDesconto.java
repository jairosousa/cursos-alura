package chainofresponsibility.descontos.model;

import chainofresponsibility.descontos.Desconto;
import strategy.imposto.Orcamento;

/**
 * Excerra a cadeia de desconto
 * @author jnsousa
 *
 */
public class SemDesconto implements Desconto{

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
		// Não tem
		
	}

}
