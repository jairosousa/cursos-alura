package decorator.imposto;

import decorator.imposto.model.ICMS;
import decorator.imposto.model.ImpostoMuitoAlto;
import strategy.imposto.Orcamento;

public class TestaImpostoMuitoAlto {

	public static void main(String[] args) {

		Orcamento orcamento = new Orcamento(500.0);

		Imposto icms = new ICMS();
		Imposto ima = new ImpostoMuitoAlto(icms);

		System.out.println(ima.calcula(orcamento));
	}

}
