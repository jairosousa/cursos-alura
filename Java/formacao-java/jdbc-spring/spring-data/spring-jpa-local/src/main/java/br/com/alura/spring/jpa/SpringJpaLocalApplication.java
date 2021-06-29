package br.com.alura.spring.jpa;

import br.com.alura.spring.jpa.service.CrudCargoService;
import br.com.alura.spring.jpa.service.CrudFuncionarioService;
import br.com.alura.spring.jpa.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.jpa.service.RelatoriosService;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaLocalApplication implements CommandLineRunner {

  private boolean system = true;

  private final CrudCargoService crudCargoService;
  private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;
  private final CrudFuncionarioService crudFuncionarioService;
  private final RelatoriosService relatoriosService;

  public SpringJpaLocalApplication(
      CrudCargoService crudCargoService,
      CrudUnidadeTrabalhoService crudUnidadeTrabalhoService,
      CrudFuncionarioService crudFuncionarioService,
      RelatoriosService relatoriosService) {
    this.crudCargoService = crudCargoService;
    this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
    this.crudFuncionarioService = crudFuncionarioService;
    this.relatoriosService = relatoriosService;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringJpaLocalApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    while (system) {
      System.out.println("qual a ação você quer executar\n");
      System.out.println("0 - Sair");
      System.out.println("1 - Cargo");
      System.out.println("2 - Unidade");
      System.out.println("3 - Funcionario");
      System.out.println("4 - Relatorios");

      int action = scanner.nextInt();

      switch (action) {
        case 1:
          crudCargoService.inicial(scanner);
          break;
        case 2:
          crudUnidadeTrabalhoService.inicial(scanner);
          break;
        case 3:
          crudFuncionarioService.inicial(scanner);
          break;
        case 4:
          relatoriosService.inicial(scanner);
          break;
        default:
          system = false;
      }
    }
  }
}
