package br.com.alura.spring.jpa;

import br.com.alura.spring.jpa.service.CrudCargoService;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaLocalApplication implements CommandLineRunner {

  private boolean system = true;

  private final CrudCargoService crudCargoService;

  public SpringJpaLocalApplication(
      CrudCargoService crudCargoService) {
    this.crudCargoService = crudCargoService;
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

      int action = scanner.nextInt();

      switch (action) {
        case 0:
          system = false;
        case 1:
          crudCargoService.inicial(scanner);
          break;
      }
    }
  }
}
