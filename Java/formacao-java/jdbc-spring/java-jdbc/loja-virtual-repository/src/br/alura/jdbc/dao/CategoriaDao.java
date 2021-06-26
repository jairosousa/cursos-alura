package br.alura.jdbc.dao;

import br.alura.jdbc.modelo.Categoria;
import br.alura.jdbc.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jairo Nascimento on 26/06/2021 - 18:18
 */
public class CategoriaDao {

  private final Connection connection;

  public CategoriaDao(Connection connection) {
    this.connection = connection;
  }

  public List<Categoria> listar() throws SQLException {
    List<Categoria> categorias = new ArrayList<>();

    String sql = "SELECT ID, NOME FROM CATEGORIA";

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

      pstm.execute();

      try (ResultSet rst = pstm.getResultSet()) {
        while (rst.next()) {
          categorias.add(new Categoria(rst.getInt(1), rst.getString(2)));
        }
      }
    }
    return categorias;
  }

  public List<Categoria> listarComProduto() throws SQLException {
    List<Categoria> categorias = new ArrayList<>();

    String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C "
        + "INNER JOIN PRODUTO P on C.ID = P.CATEGORIA_ID ";

    try (PreparedStatement pstm = connection.prepareStatement(sql)) {

      Categoria ultima = null;
      pstm.execute();

      try (ResultSet rst = pstm.getResultSet()) {
        while (rst.next()) {
          if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
            Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
            ultima = categoria;
            categorias.add(categoria);
          }
          Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
          ultima.adicionar(produto);
        }
      }
    }
    return categorias;
  }
}
