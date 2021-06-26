package br.alura.jdbc.modelo;

/**
 * @Author: Jairo Nascimento on 26/06/2021 - 11:28
 */
public class Produto {

  private Integer id;
  private final String nome;
  private final String descricao;

  public Produto(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public Produto(Integer id, String nome, String descricao) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
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

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String toString() {
    return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
  }
}
