package templatemethod.relatorio;

import java.util.ArrayList;
import java.util.List;

public class TestaRelatorios {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<Conta>();
		contas.add(new Conta("Jairo", "425", "423563-8", 500.0));
		contas.add(new Conta("Silvana", "425", "423564-0", 1000.0));
		contas.add(new Conta("Jairo Filhp", "425", "423405-1", 1500.0));
		contas.add(new Conta("Caio", "425", "423566-9", 800.0));
		
		Relatorio relatorioSimples = new RelatorioSimple();
		Relatorio relatorioComplexo = new RelatorioComplexo();
		
		relatorioSimples.imprime(contas);
		System.out.println("---------------------------");
		relatorioComplexo.imprime(contas);

	}

}
