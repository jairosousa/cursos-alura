package templatemethod.relatorio;

import java.util.List;

public class RelatorioSimple extends Relatorio {

	@Override
	protected void cabecalho() {
		System.out.println("Banco XYZ");
	}

	@Override
	protected void rodape() {
		System.out.println("(11) 1234-5678");

	}

	@Override
	protected void corpo(List<Conta> contas) {
		for (Conta conta : contas) {
			System.out.println(conta.getNome() + " - " + conta.getSaldo());
		}

	}

}
