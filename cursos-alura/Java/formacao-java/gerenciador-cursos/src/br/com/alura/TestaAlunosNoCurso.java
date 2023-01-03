package br.com.alura;

public class TestaAlunosNoCurso {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as Colleções Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Lista de Objetos", 15));
		javaColecoes.adiciona(new Aula("Relacionado Listas e Objetos", 10));

		Aluno a1 = new Aluno("Jairo Nascimento", 3944);
		Aluno a2 = new Aluno("Silvana Sousa", 3945);
		Aluno a3 = new Aluno("Jairo Filho", 3946);
		Aluno a4 = new Aluno("Caio Sousa", 3946);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		javaColecoes.matricula(a4);

		System.out.println("Quem é o aluno com matricula 3944?");
		Aluno aluno = javaColecoes.buscaMatriculado(3944);
		System.out.println("Aluno: " + aluno);
	
	}

}
