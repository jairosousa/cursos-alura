package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:48
 */
public class TestaRemocao {

  public static void main(String[] args) throws SQLException {
    Connection con = new ConnectionFactory().recuperaConexao();

    Statement stm = con.createStatement();
    boolean result = stm
        .execute("DELETE FROM produto WHERE id > 3");

    int linhasModificadas = stm.getUpdateCount();

    System.out.println("Quantidades de linhas modificadas: " + linhasModificadas);

    System.out.println("Fechando a conexão");

    con.close();
  }
}
