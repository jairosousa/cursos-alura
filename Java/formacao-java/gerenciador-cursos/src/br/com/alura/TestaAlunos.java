package br.com.alura;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {

		/**
		 * Set funciona como conjunto, não tem ordem de inserção
		 * Não tem garantia que a ordem de inserção é obedecida,
		 * 
		 * Vantagem: Não aceita elemento repetidos
		 */
		Set<String> alunos = new HashSet<>();
		alunos.add("Jairo Sousa");
		alunos.add("Silvana Sousa");
		alunos.add("Jairo Filho");
		alunos.add("Caio Sousa");
		alunos.add("Jhair dSousa");
		alunos.add("Silvana Sousa");
		alunos.add("Fulano de Tal");
		
		System.out.println(alunos);
		System.out.println(alunos.size());
		
		alunos.forEach(aluno -> System.out.println(aluno));
		
		boolean jairoEstaMatriculado = alunos.contains("Jairo Sousa");
		
		alunos.remove("Fulano de Tal");
		
		System.out.println(jairoEstaMatriculado);

		alunos.forEach(aluno -> System.out.println(aluno));
	}

}
