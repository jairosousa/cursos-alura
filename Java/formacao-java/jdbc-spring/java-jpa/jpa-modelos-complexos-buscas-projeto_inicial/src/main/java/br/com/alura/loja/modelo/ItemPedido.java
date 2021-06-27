package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 13:47
 */
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "preco_unitario")
  private BigDecimal precoUnitario;

  private int quantidade;

  @ManyToOne
  private Pedido pedido;

  @ManyToOne
  private Produto produto;

  public ItemPedido() {
  }

  public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
    this.quantidade = quantidade;
    this.precoUnitario = produto.getPreco();
    this.pedido = pedido;
    this.produto = produto;
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getPrecoUnitario() {
    return precoUnitario;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public BigDecimal getValor() {
    return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
  }
}
