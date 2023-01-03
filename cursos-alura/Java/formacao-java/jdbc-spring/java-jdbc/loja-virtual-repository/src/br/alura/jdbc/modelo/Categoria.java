package br.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jairo Nascimento on 26/06/2021 - 18:17
 */
public class Categoria {

  private Integer id;
  private String nome;
  private List<Produto> produtos;

  public List<Produto> getProdutos() {
    return produtos;
  }

  public Categoria(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return String.format("%d - %s", this.id, this.nome);
  }

  public void adicionar(Produto produto) {
    if (produtos == null) {
      this.produtos = new ArrayList<>();
    }
    this.produtos.add(produto);
  }
}
