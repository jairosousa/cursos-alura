package br.alura.jdbc.main;

import br.alura.jdbc.dao.ConnectionFactory;
import br.alura.jdbc.dao.ProdutoDao;
import br.alura.jdbc.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:07
 */
public class TestaListagemComProduto {

  public static void main(String[] args) throws SQLException {

    try (Connection conn = new ConnectionFactory().recuperaConexao()) {
      ProdutoDao produtoDao = new ProdutoDao(conn);
      List<Produto> produtos = produtoDao.listar();
    }
  }

}
