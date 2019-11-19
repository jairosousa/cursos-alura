package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencia = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencia++);
		empresa1.setNome("Caelum");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencia++);
		empresa2.setNome("Alura");

		Banco.lista.addAll(Arrays.asList(empresa1, empresa2));
		
		Usuario u1 = new Usuario();
		u1.setLogin("jairo");
		u1.setSenha("12345");
		
		Usuario u2 = new Usuario();
		u2.setLogin("silvana");
		u2.setSenha("12345");
		
		Banco.listaUsuarios.addAll(Arrays.asList(u1, u2));
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

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
