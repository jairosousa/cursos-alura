package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:48
 */
public class TestaInsercaoComParametro {

  public static void main(String[] args) throws SQLException {
    Connection con = new ConnectionFactory().recuperaConexao();

    String nome = "Teclado";
    String descricao = "Teclado sem fio";

    PreparedStatement stm = con
        .prepareStatement("INSERT INTO produto (nome,descricao) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
    stm.setString(1, nome);
    stm.setString(2, descricao);

    stm.execute();

    ResultSet rst = stm.getGeneratedKeys();

    while (rst.next()) {
      Integer id = rst.getInt(1);
      System.out.println("O ID criado foi : " + id);
    }

    System.out.println("Fechando a conexão");

    con.close();
  }
}
