package br.com.alura.spring.jpa.data.orm;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @Author: Jairo Nascimento on 28/06/2021 - 08:25
 */
@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  private String endereco;

  @ManyToMany(mappedBy = "unidadeTrabalhos", fetch = FetchType.EAGER)
  private List<Funcionario> funcionarios;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String descricao) {
    this.nome = descricao;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public List<Funcionario> getFuncionarios() {
    return funcionarios;
  }

  public void setFuncionarios(List<Funcionario> funcionarios) {
    this.funcionarios = funcionarios;
  }

  @Override
  public String toString() {
    return "UnidadeTrabalho{" +
        "id=" + id +
        ", descricao='" + nome + '\'' +
        ", endereco='" + endereco + '\'' +
        '}';
  }
}
