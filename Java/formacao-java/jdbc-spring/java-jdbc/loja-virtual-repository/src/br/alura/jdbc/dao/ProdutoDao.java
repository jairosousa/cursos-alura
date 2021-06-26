package br.alura.jdbc.dao;

import br.alura.jdbc.modelo.Categoria;
import br.alura.jdbc.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jairo Nascimento on 26/06/2021 - 16:19
 */
public class ProdutoDao {

  private final Connection connection;

  public ProdutoDao(Connection connection) {
    this.connection = connection;
  }

  public void salvar(Produto produto) throws SQLException {

    String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?, ?)";

    try (PreparedStatement pstm = connection
        .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      pstm.setString(1, produto.getNome());
      pstm.setString(2, produto.getDescricao());

      pstm.execute();

      try (ResultSet rst = pstm.getGeneratedKeys()) {
        while (rst.next()) {
          produto.setId(rst.getInt(1));
        }
      }
    }
  }

  public List<Produto> listar() throws SQLException {

    List<Produto> produtos = new ArrayList<>();
    String sql = "select ID, NOME, DESCRICAO from PRODUTO";

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

      pstm.execute();

      try (ResultSet rst = pstm.getResultSet()) {
        while (rst.next()) {
          Integer id = rst.getInt(1);
          String nome = rst.getString(2);
          String descricao = rst.getString(3);

          produtos.add(new Produto(id, nome, descricao));

        }
      }

    }
    return produtos;
  }

  public List<Produto> buscar(Categoria categoria) throws SQLException {
    List<Produto> produtos = new ArrayList<>();
    String sql = "SELECT ID, NOME, DESCRICAO from PRODUTO WHERE CATEGORIA_ID = ?";

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {
      pstm.setInt(1, categoria.getId());
      pstm.execute();

      try (ResultSet rst = pstm.getResultSet()) {
        while (rst.next()) {
          Integer id = rst.getInt(1);
          String nome = rst.getString(2);
          String descricao = rst.getString(3);

          produtos.add(new Produto(id, nome, descricao));

        }
      }

    }
    return produtos;
  }
}
