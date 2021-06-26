package br.alura.jdbc.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:41
 */
public class ConnectionFactory {

  public DataSource dataSource;

  public ConnectionFactory() {
    ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
    pooledDataSource.setJdbcUrl(
        "jdbc:mysql://localhost/loja_virtual?useSSL=false&useTimezone=true&serverTimezone=UTC");
    pooledDataSource.setUser("root");
    pooledDataSource.setPassword("root");
    pooledDataSource.setMaxPoolSize(15);

    this.dataSource = pooledDataSource;
  }

  public Connection recuperaConexao() throws SQLException {
    return this.dataSource.getConnection();
  }

}
