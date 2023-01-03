package br.com.alura.spring.jpa.data.orm;

/**
 * @Author: Jairo Nascimento on 29/06/2021 - 07:04
 */
public class FuncionarioDTO {

  private Integer id;
  private String nome;
  private Double salario;

  public FuncionarioDTO(Integer id, String nome, Double salario) {
    this.id = id;
    this.nome = nome;
    this.salario = salario;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }

  @Override
  public String toString() {
    return "FuncionarioDTO{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", salario=" + salario +
        '}';
  }
}
