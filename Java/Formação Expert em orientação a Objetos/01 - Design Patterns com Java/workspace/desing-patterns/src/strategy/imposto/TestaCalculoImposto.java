package strategy.imposto;

import strategy.imposto.model.ICCC;
import strategy.imposto.model.ICMS;
import strategy.imposto.model.ISS;
import strategy.imposto.model.Imposto;

public class TestaCalculoImposto {

	public static void main(String[] args) {
		
		Imposto icms = new ICMS();
		Imposto iss = new ISS();
		Imposto iccc = new ICCC();
		
		Orcamento orcamento = new Orcamento(2500.0);
		
		CalculadorDeImposto ci = new CalculadorDeImposto();
		
		// Calculando ICMS
		ci.realizaCalculo(orcamento, icms);
		
		// Calculando ISS
		ci.realizaCalculo(orcamento, iss);
		
		// Calculando ICCC
		ci.realizaCalculo(orcamento, iccc);
		

	}

}
