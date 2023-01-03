package br.com.alura.loja.modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 20:52
 */
@Embeddable
public class CategoriaId implements Serializable {

  private static final long serialVersionUID = 4442799748649225519L;

  private String nome;
  private String tipo;

  public CategoriaId() {
  }

  public CategoriaId(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }

  public String getNome() {
    return nome;
  }

  public String getTipo() {
    return tipo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
