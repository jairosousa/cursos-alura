package decorator.filtro;

import java.util.ArrayList;
import java.util.List;

public class FiltroMenorQue100Reais extends Filtro {

	public FiltroMenorQue100Reais() {
		super();
	}

	public FiltroMenorQue100Reais(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta c : contas) {
			if (c.getValor() < 100)
				filtrada.add(c);
		}

		filtrada.addAll(proximo(contas));
		return filtrada;
	}

}
