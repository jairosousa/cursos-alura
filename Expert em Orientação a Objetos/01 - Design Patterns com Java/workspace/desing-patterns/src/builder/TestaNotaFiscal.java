package builder;

import java.util.Calendar;

public class TestaNotaFiscal {

	public static void main(String[] args) {
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		
		NotaFiscal nf = builder.paraEmpresa("Caelum Ensino e Inovação")
		.comCnpj("12.345.678/0001-12")
		.com(new ItemDaNotaBuider().comNome("Item 1").comValor(200.0).constroi())
		.com(new ItemDaNotaBuider().comNome("Item 2").comValor(300.0).constroi())
		.com(new ItemDaNotaBuider().comNome("Item 3").comValor(400.0).constroi())
		.comObservacoes("Observação")
		.naData(Calendar.getInstance())
		.constroi();
		// e assim por diante ...
		
//		NotaFiscal nf = builder.constroi();
		
		System.out.println(nf.getValorBruto());
		System.out.println(nf.getImpostos());
		System.out.println(nf.getDataEmissao());

	}

}
