package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:07
 */
public class TestaListagem {

  public static void main(String[] args) throws SQLException {

    Connection con = new ConnectionFactory().recuperaConexao();

    Statement stm = con.createStatement();

    boolean resultado = stm.execute("select id, nome, descricao from produto;");

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

    con.close();
  }

}
