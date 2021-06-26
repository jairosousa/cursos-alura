package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:41
 */
public class ConnectionFactory {

  public Connection recuperaConexao() throws SQLException {
    return DriverManager
        .getConnection("jdbc:mysql://localhost/loja_virtual?useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "root");
  }

}
