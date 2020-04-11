package templatemethod.imposto;

import strategy.imposto.Item;
import strategy.imposto.Orcamento;
import strategy.imposto.model.Imposto;

public class TestaImpostoTemplate {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(900.0);
		orcamento.addItem(new Item("Caneta", 50.0));
		orcamento.addItem(new Item("Lapiz", 50.0));
		orcamento.addItem(new Item("Celular", 200.0));
		orcamento.addItem(new Item("Notpad", 300.0));
		orcamento.addItem(new Item("Notpad", 300.0));
		
		Imposto icpp = new ICPP();
		double impostoIcpp = icpp.calcula(orcamento);
		
		Imposto ikcv = new IKCV();
		double impostoIkcv= ikcv.calcula(orcamento);
		
		Imposto ihit = new IHIT();
		double impostoIhit = ihit.calcula(orcamento);
		
		System.out.printf("%.2f \n",impostoIcpp);
		System.out.printf("%.2f \n",impostoIkcv);
		System.out.printf("%.2f",impostoIhit);

	}

}
