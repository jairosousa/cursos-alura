package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<Curso>();
    cursos.add(new Curso("Python", 45));
    cursos.add(new Curso("JavaScript", 150));
    cursos.add(new Curso("Java 8", 113));
    cursos.add(new Curso("C", 55));

//        Com lambda:
    cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));

//        Com method reference:
    cursos.sort(Comparator.comparingInt(Curso::getAlunos));

    cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .forEach(c -> System.out.println(c.getNome()));

    Stream<String> nomes = cursos.stream().map(Curso::getNome);
    nomes.forEach(System.out::println);

    cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .map(c -> c.getAlunos())
        .forEach(x -> System.out.println(x));
// ou
    cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .map(Curso::getAlunos)
        .forEach(System.out::println);

    System.out.println(cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .findFirst());

    OptionalDouble average = cursos.stream()
        .mapToInt(c -> c.getAlunos())
        .average();

    System.out.println(average.getAsDouble());

    Stream<Curso> stream = cursos.stream()
        .filter(c -> c.getAlunos() > 50);

    List<Curso> cursosFiltrados = cursos.stream()
        .filter(c -> c.getAlunos() > 50)
        .collect(Collectors.toList());

    cursosFiltrados.forEach(System.out::println);

    System.out.println("\nMap");
    Map<String, Integer> map = cursos.stream()
        .filter(c -> c.getAlunos() >= 100)
        .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos));

    System.out.println(map);

    System.out.println("\nBiConsumers");
    cursos.stream()
        .filter(c -> c.getAlunos() >= 100)
        .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
        .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));

      System.out.println("\nQuantidades total de alunos");
      int totalAlunos = cursos.stream()
          .mapToInt(Curso::getAlunos)
          .sum();
      System.out.println(totalAlunos);
  }
}
