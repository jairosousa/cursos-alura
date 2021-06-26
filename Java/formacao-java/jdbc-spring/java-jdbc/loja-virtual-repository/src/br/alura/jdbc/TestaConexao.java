package br.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 19:43
 */
public class TestaConexao {

  public static void main(String[] args) throws SQLException {
    Connection con = new ConnectionFactory().recuperaConexao();

    System.out.println("Fechando a conexão");

    con.close();
  }

}
