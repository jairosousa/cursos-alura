package chainofresponsibility.descontos;

import strategy.imposto.Item;
import strategy.imposto.Orcamento;

public class TestaDescontos {

	public static void main(String[] args) {
		
		CalculadorDeDescontos calculador = new CalculadorDeDescontos();
		
		Orcamento orcamento = new Orcamento(500.0);
		
		orcamento.addItem(new Item("Caneta", 250.0));
		orcamento.addItem(new Item("Lapiz", 250.0));
		
		double desconto = calculador.calcula(orcamento);
		
		System.out.println(desconto);

	}

}
