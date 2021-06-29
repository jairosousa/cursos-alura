package br.com.alura.spring.jpa.data.repository;

import br.com.alura.spring.jpa.data.orm.Funcionario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Jairo Nascimento on 28/06/2021 - 06:40
 */
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {

      List<Funcionario> findByNome(String nome);

      @Query("SELECT f FROM Funcionario f "
          + "WHERE f.nome like %:nome% "
          + "AND f.salario >= :salario "
          + "AND f.dataContratacao > :dataContratacao")
      List<Funcionario> findByNomeSalariMaiorDataContratacao(String nome, Double salario, LocalDate dataContratacao);

      @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
      List<Funcionario> findDataContratacao(LocalDate data);
}
