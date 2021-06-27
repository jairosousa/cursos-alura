package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 20:32
 */
@Entity
@Table(name = "livros")
public class Livro extends Produto {

  private String autor;
  private String numeroDePaginas;

  public Livro() {
  }

  public Livro(String autor, String numeroDePaginas) {
    this.autor = autor;
    this.numeroDePaginas = numeroDePaginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public void setNumeroDePaginas(String numeroDePaginas) {
    this.numeroDePaginas = numeroDePaginas;
  }
}
