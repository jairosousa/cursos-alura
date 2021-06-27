package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 13:10
 */
@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private DadosPessoais dadosPessoais;

  public Cliente(String nome, String cpf) {
    this.dadosPessoais = new DadosPessoais(nome,cpf);
  }

  public Cliente() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DadosPessoais getDadosPessoais() {
    return dadosPessoais;
  }

  @Override
  public String toString() {
    return "{" +
        "id=" + id +
        ", nome='" + dadosPessoais.getNome() + '\'' +
        ", cpf='" + dadosPessoais.getCpf() + '\'' +
        '}';
  }
}
