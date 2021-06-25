package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 19:43
 */
public class TestaConexao {

  public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost/loja_virtual?useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "root");

    System.out.println("Fechando a conexão");

    connection.close();
  }

}
