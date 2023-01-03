package br.alura.jdbc.main;

import br.alura.jdbc.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: Jairo Nascimento on 26/06/2021 - 10:37
 */
public class TestaPollConexoes {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory factory = new ConnectionFactory();

    for (int i = 0; i < 20; i++) {
      Connection conn = factory.recuperaConexao();
      System.out.println("Conexao do número: " + (i + 1));
    }
  }
}
