package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Caelum");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Alura");

		Banco.lista.addAll(Arrays.asList(empresa1, empresa2));
	}

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
