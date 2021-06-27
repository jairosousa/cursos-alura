package br.com.alura.jdbc.controller;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;
import java.sql.Connection;
import java.util.List;

public class ProdutoController {

  private final ProdutoDAO produtoDAO;

  public ProdutoController() {
    Connection connection = new ConnectionFactory().recuperarConexao();
    this.produtoDAO = new ProdutoDAO(connection);
  }

  public void deletar(Integer id) {
    produtoDAO.deletar(id);
  }

  public void salvar(Produto produto) {
    produtoDAO.salvar(produto);
  }

  public List<Produto> listar() {
    return produtoDAO.listar();
  }

  public void alterar(String nome, String descricao, Integer id) {
    produtoDAO.alterar(nome, descricao, id);
  }
}
