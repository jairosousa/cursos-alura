package br.com.alura.spring.jpa.service;

import br.com.alura.spring.jpa.data.orm.Cargo;
import br.com.alura.spring.jpa.data.repository.CargoRepository;
import java.util.Scanner;
import org.springframework.stereotype.Service;

/**
 * @Author: Jairo Nascimento on 28/06/2021 - 07:30
 */
@Service
public class CrudCargoService {

  private Boolean system = true;

  private final CargoRepository cargoRepository;

  public CrudCargoService(CargoRepository cargoRepository) {
    this.cargoRepository = cargoRepository;
  }

  public void inicial(Scanner scanner) {
    while (system) {
      System.out.println("Qual a ação de cargo deseja executar?\n");
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
    System.out.println("Descricao cargo");
    String descricao = scanner.next();
    Cargo cargo = new Cargo();
    cargo.setDescricao(descricao);

    cargoRepository.save(cargo);
    System.out.println("Cargo Salvo!");
  }

  private void atualizar(Scanner scanner) {
    System.out.println("id");
    Integer id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Descrição Cargo");
    String descricao = scanner.nextLine();
    Cargo cargo = new Cargo();
    cargo.setId(id);
    cargo.setDescricao(descricao);

    cargoRepository.save(cargo);
    System.out.println("Cargo Atualizado!");
  }

  private void visualizar() {
    cargoRepository.findAll().forEach(System.out::println);
  }
  private void deletar(Scanner scanner) {
    System.out.println("id");
    Integer id = scanner.nextInt();
    cargoRepository.deleteById(id);
    System.out.println("Cargo Deletado!");
  }
}
