package br.alura.jdbc.main;

import br.alura.jdbc.dao.ConnectionFactory;
import br.alura.jdbc.dao.ProdutoDao;
import br.alura.jdbc.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Jairo Nascimento on 26/06/2021 - 11:30
 */
public class TestaIsercaoEListagemProduto {

  public static void main(String[] args) throws SQLException {

    Produto comoda = new Produto("Microondas", "450L");

    try (Connection conn = new ConnectionFactory().recuperaConexao()) {

      ProdutoDao produtoDao = new ProdutoDao(conn);
      produtoDao.salvar(comoda);

      List<Produto> produtos = produtoDao.listar();

      produtos.forEach(System.out::println);

    }
  }

}
