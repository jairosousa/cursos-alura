package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {

		String aula1 = "Conhecendo mais as listas";
		String aula2 = "Modelando a classe aula";
		String aula3 = "Trabalhando em Cursos e Sets";

		ArrayList<String> aulas = new ArrayList<>();

		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);

		aulas.remove(0);

		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}

		String primeiraAula = aulas.get(0);

		System.out.println(primeiraAula);

		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("Aulas: " + aulas.get(i));
		}

		System.out.println(aulas.size());

		aulas.forEach(aula -> {
			System.out.println("Percorrendo: ");
			System.out.println("aula: " + aula);
		});
		
		aulas.add("Aumentando nosso conhecimento");
		
		System.out.println("====Antes da ordenação===== ");
		aulas.forEach(aula -> {
			System.out.println("aula: " + aula);
		});
		
		Collections.sort(aulas);
		
		System.out.println("Depois de ordenado: ");
		aulas.forEach(aula -> {
			System.out.println("aula: " + aula);
		});
	}

}
