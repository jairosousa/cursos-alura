package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencia = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencia++);
		empresa1.setNome("Caelum");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencia++);
		empresa2.setNome("Alura");

		Banco.lista.addAll(Arrays.asList(empresa1, empresa2));
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencia++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == id) {
//				lista.remove(empresa);
				it.remove();
			}

		}

	}

	public Empresa buscarEmpresa(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

}
