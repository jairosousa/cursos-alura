package observer;

import java.util.Calendar;

import builder.ItemDaNota;
import builder.NotaFiscal;
import builder.NotaFiscalBuilder;

public class TesteMultiplicador {

	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.adicionaAcao(new Multiplicador(2));
		builder.adicionaAcao(new Multiplicador(3));
		builder.adicionaAcao(new Multiplicador(5.5));

		NotaFiscal notaFiscal = builder.paraEmpresa("Caelum")
				.comCnpj("123.456.789/0001-10")
				.com(new ItemDaNota("item 1", 100.0))
				.com(new ItemDaNota("item 2", 200.0))
				.com(new ItemDaNota("item 3", 300.0))
				.comObservacoes("entregar notaFiscal pessoalmente")
				.naData(Calendar.getInstance())
				.constroi();

	}

}
