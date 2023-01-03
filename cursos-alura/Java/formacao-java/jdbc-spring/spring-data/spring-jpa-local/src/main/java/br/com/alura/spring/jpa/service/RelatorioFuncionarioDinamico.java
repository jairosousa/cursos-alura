package br.com.alura.spring.jpa.service;

import br.com.alura.spring.jpa.data.orm.Funcionario;
import br.com.alura.spring.jpa.data.repository.FuncionarioRepository;
import br.com.alura.spring.jpa.specification.SpecificationFuncionario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @Author: Jairo Nascimento on 29/06/2021 - 07:57
 */
@Service
public class RelatorioFuncionarioDinamico {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final FuncionarioRepository funcionarioRepository;

  public RelatorioFuncionarioDinamico(
      FuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

  public void inicial(Scanner scanner) {

    System.out.println("Digite o nome");
    String nome = scanner.next();
    if (nome.equalsIgnoreCase("null")) {
      nome = null;
    }

    System.out.println("Digite o cpf");
    String cpf = scanner.next();
    if (cpf.equalsIgnoreCase("null")) {
      cpf = null;
    }

    System.out.println("Digite o salario (0 = null)");
    Double salario = scanner.nextDouble();
    if (salario == 0) {
      salario = null;
    }

    System.out.println("Digite o data contratação");
    String data = scanner.next();
    LocalDate dataContratacao;
    if (data.equalsIgnoreCase("null")) {
      dataContratacao = null;
    } else {
      dataContratacao = LocalDate.parse(data, formatter);
    }

    List<Funcionario> funcionarios = funcionarioRepository.findAll(
        Specification.where(
            SpecificationFuncionario.nome(nome))
            .or(SpecificationFuncionario.cpf(cpf))
            .or(SpecificationFuncionario.salario(salario))
            .or(SpecificationFuncionario.dataContracacao(dataContratacao))
    );
    funcionarios.forEach(System.out::println);
  }
}
