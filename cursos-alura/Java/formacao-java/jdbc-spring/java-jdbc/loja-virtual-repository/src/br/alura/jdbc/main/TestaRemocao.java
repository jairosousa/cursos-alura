package br.alura.jdbc.main;

import br.alura.jdbc.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:48
 */
public class TestaRemocao {

  public static void main(String[] args) throws SQLException {
    Connection con = new ConnectionFactory().recuperaConexao();

    PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
    stm.setInt(1, 3);

    boolean result = stm
        .execute();

    int linhasModificadas = stm.getUpdateCount();

    System.out.println("Quantidades de linhas modificadas: " + linhasModificadas);

    System.out.println("Fechando a conexão");

    stm.close();
    con.close();
  }
}
