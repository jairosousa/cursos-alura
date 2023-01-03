package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as Colleções Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Lista de Objetos", 15));
		javaColecoes.adiciona(new Aula("Relacionado Listas e Objetos", 10));
		
		List<Aula> aulaImutaveis = javaColecoes.getAulas();
		
		List<Aula> aulaMutaveis = new ArrayList<>(aulaImutaveis);
		
		Collections.sort(aulaMutaveis);
		
		System.out.println(aulaMutaveis);
		
		System.out.println(javaColecoes.tempoTotal());
		
		System.out.println(javaColecoes);
		
	}

}
