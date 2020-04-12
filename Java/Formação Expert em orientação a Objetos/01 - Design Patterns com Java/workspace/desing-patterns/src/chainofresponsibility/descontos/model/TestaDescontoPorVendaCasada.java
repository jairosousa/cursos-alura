package chainofresponsibility.descontos.model;

import chainofresponsibility.descontos.Desconto;
import strategy.imposto.Item;
import strategy.imposto.Orcamento;

public class TestaDescontoPorVendaCasada {

	public static void main(String[] args) {

		Orcamento orcamento = new Orcamento(400.0);
		orcamento.addItem(new Item("CANETA", 300.00));
		orcamento.addItem(new Item("LAPIS", 300.00));

		Desconto d1 = new DescontoPorMaisDeCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();

		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);

		double desconto = d1.desconta(orcamento);

		System.out.printf("%.2f", desconto);

	}
}
