package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:48
 */
public class TestaInsercao {

  public static void main(String[] args) throws SQLException {
    Connection con = new ConnectionFactory().recuperaConexao();

    Statement stm = con.createStatement();
    boolean result = stm
        .execute("INSERT INTO produto (nome,descricao) VALUES('Teclado','Teclado sem fio')",
            Statement.RETURN_GENERATED_KEYS);

    ResultSet rst = stm.getGeneratedKeys();

    while (rst.next()) {
      Integer id = rst.getInt(1);
      System.out.println("O ID criado foi : " + id);
    }

    System.out.println("Fechando a conexão");

    con.close();
  }
}
