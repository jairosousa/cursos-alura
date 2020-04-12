package state;

import state.model.Orcamento;

public class TestaDeDescontoExtra {

	public static void main(String[] args) {
		Orcamento reforma = new Orcamento(500.0);
		
		reforma.aplicaDescontoExtra();
		reforma.aplicaDescontoExtra();
		
		System.out.println("Em aprovação: "+ reforma.getValor());
		
		reforma.aprova();
		
		reforma.aplicaDescontoExtra();

		System.out.println("aprovado: "+ reforma.getValor());
		
		reforma.finaliza();
		reforma.aplicaDescontoExtra();
		System.out.println("Finalizado: "+ reforma.getValor());
	}

}
