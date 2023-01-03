package br.alura.jdbc.main;

import br.alura.jdbc.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:07
 */
public class TestaListagem {

  public static void main(String[] args) throws SQLException {

    Connection con = new ConnectionFactory().recuperaConexao();

    PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO from PRODUTO");

    boolean resultado = stm.execute();

    System.out.println(resultado);

    ResultSet rst = stm.getResultSet();

    while (rst.next()) {
      Integer id = rst.getInt("id");
      String nome = rst.getString("nome");
      String descricao = rst.getString("descricao");

      System.out.println("ID: " + id + "; NOME: " + nome + "; DESCRICAO: " + descricao);
      System.out.println("===============================");
    }

    System.out.println("Fechando a conexão");
    stm.close();
    con.close();
  }

}
