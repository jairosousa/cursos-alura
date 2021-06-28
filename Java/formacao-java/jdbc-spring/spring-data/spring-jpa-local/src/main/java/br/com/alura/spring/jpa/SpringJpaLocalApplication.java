package br.com.alura.spring.jpa;

import br.com.alura.spring.jpa.data.orm.Cargo;
import br.com.alura.spring.jpa.data.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaLocalApplication implements CommandLineRunner {

  private final CargoRepository repository;

  public SpringJpaLocalApplication(
      CargoRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringJpaLocalApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Cargo cargo = new Cargo();
    cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
    repository.save(cargo);
  }
}
