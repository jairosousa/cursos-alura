package observer;

import builder.ItemDaNotaBuider;
import builder.NotaFiscal;
import builder.NotaFiscalBuilder;

public class TesteAcoes {

	public static void main(String[] args) {
		NotaFiscalBuilder buider = new NotaFiscalBuilder();
		buider.adicionaAcao(new EnviadorDeEmail());
		buider.adicionaAcao(new NotaFiscalDao());
		buider.adicionaAcao(new EnviadorDeSms());
		buider.adicionaAcao(new Impressora());

		NotaFiscal nf = buider.paraEmpresa("Caelum").comCnpj("123")
				.com(new ItemDaNotaBuider().comNome("nome").comValor(100.0).constroi())
				.comObservacoes("obs")
				.constroi();

		System.out.println(nf.getValorBruto());
	}

}
