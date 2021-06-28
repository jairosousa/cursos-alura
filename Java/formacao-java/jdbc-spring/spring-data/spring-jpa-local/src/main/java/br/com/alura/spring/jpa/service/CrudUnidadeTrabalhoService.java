package br.com.alura.spring.jpa.service;

import br.com.alura.spring.jpa.data.orm.UnidadeTrabalho;
import br.com.alura.spring.jpa.data.repository.UnidadeTrabalhoRepository;
import java.util.Scanner;
import org.springframework.stereotype.Service;

/**
 * @Author: Jairo Nascimento on 28/06/2021 - 07:30
 */
@Service
public class CrudUnidadeTrabalhoService {

  private Boolean system = true;

  private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

  public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
    this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
  }

  public void inicial(Scanner scanner) {
    while (system) {
      System.out.println("Qual a ação de unidade trabalho deseja executar?\n");
      System.out.println("0 - Sair");
      System.out.println("1 - Salvar");
      System.out.println("2 - atualizar");
      System.out.println("3 - visualizar");
      System.out.println("4 - Deletar");
      Integer opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          salvar(scanner);
          break;
        case 2:
          atualizar(scanner);
          break;
        case 3:
          visualizar();
          break;
        case 4:
          deletar(scanner);
          break;
        default:
          system = false;
          break;
      }
    }
  }


  private void salvar(Scanner scanner) {
    System.out.println("nome unidade Trabalho");
    String nome = scanner.next();

    System.out.println("Endereco unidade Trabalho");
    String endereco = scanner.next();

    UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
    unidadeTrabalho.setNome(nome);
    unidadeTrabalho.setEndereco(endereco);
    unidadeTrabalhoRepository.save(unidadeTrabalho);
    System.out.println("UnidadeTrabalho Salvo!");
  }

  private void atualizar(Scanner scanner) {
    System.out.println("id");
    Integer id = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Nome Unidade Trabalho");
    String nome = scanner.nextLine();
    scanner.nextLine();

    System.out.println("Endereco unidade Trabalho");
    String endereco = scanner.next();

    UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
    unidadeTrabalho.setId(id);
    unidadeTrabalho.setNome(nome);
    unidadeTrabalho.setEndereco(endereco);

    unidadeTrabalhoRepository.save(unidadeTrabalho);
    System.out.println("Unidade Trabalho Atualizado!");
  }

  private void visualizar() {
    unidadeTrabalhoRepository.findAll().forEach(System.out::println);
  }
  private void deletar(Scanner scanner) {
    System.out.println("id");
    Integer id = scanner.nextInt();
    unidadeTrabalhoRepository.deleteById(id);
    System.out.println("Unidade Trabalho Deletado!");
  }
}
