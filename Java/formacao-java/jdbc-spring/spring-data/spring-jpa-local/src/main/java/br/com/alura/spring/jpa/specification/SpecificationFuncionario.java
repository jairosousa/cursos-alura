package br.com.alura.spring.jpa.specification;

import br.com.alura.spring.jpa.data.orm.Funcionario;
import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author: Jairo Nascimento on 29/06/2021 - 07:52
 */
public class SpecificationFuncionario {

  public static Specification<Funcionario> nome(String nome) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.like(root.get("nome"), "%"+nome+"%");
  }

  public static Specification<Funcionario> cpf(String cpf) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.equal(root.get("cpf"), cpf);
  }

  public static Specification<Funcionario> salario(Double salario) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.greaterThan(root.get("salario"), salario);
  }

  public static Specification<Funcionario> dataContracacao(LocalDate dataContratacao) {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
  }
}
