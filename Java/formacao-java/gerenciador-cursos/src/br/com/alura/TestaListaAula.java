package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaAula {

	public static void main(String[] args) {

		Aula aula1 = new Aula("Revisando ArrayList", 21);
		Aula aula2 = new Aula("Lista de Objetos", 15);
		Aula aula3 = new Aula("Relacionado Listas e Objetos", 10);
		
		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		Collections.sort(aulas);
		
		System.out.println(aulas);
		
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getTempo));
		
		System.out.println(aulas);
		
	}

}
