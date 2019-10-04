package br.com.alura;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Deicha as listas imutáveis
	 * 
	 * @return
	 */
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas); // Retorna lista que não pode ser modificado tipo add, remove
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public int tempoTotal() {
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		return tempoTotal;
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", instrutor=" + instrutor + ", Tempo Total=" + tempoTotal() + 
				", Aulas: "+ aulas + "]";
	}
	
	
}
