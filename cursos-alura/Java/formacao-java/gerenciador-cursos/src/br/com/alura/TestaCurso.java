package br.com.alura;

import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as Colleções Java", "Paulo Silveira");
		
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21)); Lança um exceção

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Lista de Objetos", 15));
		javaColecoes.adiciona(new Aula("Relacionado Listas e Objetos", 10));
		
		System.out.println(javaColecoes.getAulas());
		
		
		
	}

}
