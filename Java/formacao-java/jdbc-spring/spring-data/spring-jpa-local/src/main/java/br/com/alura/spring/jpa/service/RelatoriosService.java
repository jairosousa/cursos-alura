package br.com.alura.spring.jpa.service;

import br.com.alura.spring.jpa.data.orm.Funcionario;
import br.com.alura.spring.jpa.data.repository.FuncionarioRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Service;

/**
 * @Author: Jairo Nascimento on 28/06/2021 - 15:15
 */
@Service
public class RelatoriosService {

  private Boolean system = true;
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final FuncionarioRepository funcionarioRepository;

  public RelatoriosService(FuncionarioRepository cargoRepository) {
    this.funcionarioRepository = cargoRepository;
  }

  public void inicial(Scanner scanner) {
    while (system) {
      System.out.println("Qual a ação de cargo deseja executar?\n");
      System.out.println("0 - Sair");
      System.out.println("1 - Busca Funcionario por nome");
      System.out.println("2 - Busca Funcionario por nome, salario e data contratação");
      System.out.println("3 - Busca Funcionario por data contratação");
      Integer opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          buscaFuncionarioNome(scanner);
          break;

        case 2:
          buscaFuncionarioNomeSalarioMaiorData(scanner);
          break;
        case 3:
          buscaFuncionarioDataContratacao(scanner);
          break;

        default:
          system = false;
          break;
      }
    }
  }

  private void buscaFuncionarioNome(Scanner scanner) {
    System.out.println("Escreva o nome:");
    String nome = scanner.next();

    List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);

    funcionarios.forEach(System.out::println);
  }

  private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
    System.out.println("Qual nome deseja pesquisar");
    String nome = scanner.next();

    System.out.println("Qual data contratação deseja pesquisar");
    String dataContratacao = scanner.next();
    LocalDate localDate = LocalDate.parse(dataContratacao, formatter);

    System.out.println("Qual salario deseja pesquisar");
    Double salario = scanner.nextDouble();

    funcionarioRepository.findByNomeSalariMaiorDataContratacao(nome, salario, localDate)
        .forEach(System.out::println);
  }

  private void buscaFuncionarioDataContratacao(Scanner scanner) {
    System.out.println("Qual data contratação deseja pesquisar");
    String dataContratacao = scanner.next();
    LocalDate localDate = LocalDate.parse(dataContratacao, formatter);

    funcionarioRepository.findDataContratacao(localDate)
        .forEach(System.out::println);

  }
}
