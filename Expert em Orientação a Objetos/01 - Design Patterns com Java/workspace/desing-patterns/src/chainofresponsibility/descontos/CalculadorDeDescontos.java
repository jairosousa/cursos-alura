package chainofresponsibility.descontos;

import chainofresponsibility.descontos.model.DescontoPorMaisDeCincoItens;
import chainofresponsibility.descontos.model.DescontoPorMaisDeQuinhentosReais;
import chainofresponsibility.descontos.model.SemDesconto;
import strategy.imposto.Orcamento;

public class CalculadorDeDescontos {
	
	/**
	 * Calcula os descontos por orçamento
	 * @param orcamento
	 * @return
	 */
	public double calcula(Orcamento orcamento) {
		
		Desconto d1 = new DescontoPorMaisDeCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
		Desconto d3 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		
		return d1.desconta(orcamento);
		
	}

}
