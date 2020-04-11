package decorator.imposto;

import decorator.imposto.model.ICMS;
import decorator.imposto.model.ISS;
import strategy.imposto.Orcamento;

public class TesteDeImpostosComplexos {

	public static void main(String[] args) {
		Imposto icms = new ICMS();
		Imposto iss = new ISS(icms);

		Orcamento orcamento = new Orcamento(500.0);

		double valor = iss.calcula(orcamento);

		System.out.println(valor);

	}

}
