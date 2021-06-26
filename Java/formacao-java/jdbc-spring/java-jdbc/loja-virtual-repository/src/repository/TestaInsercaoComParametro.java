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

    try (Connection con = new ConnectionFactory().recuperaConexao()) {
      con.setAutoCommit(false);

      try (PreparedStatement stm = con
          .prepareStatement("INSERT INTO produto (nome,descricao) VALUES(?,?)",
              Statement.RETURN_GENERATED_KEYS)) {

        adicionarVariavel("Teclado", "Teclado sem fio", stm);
        adicionarVariavel("Smart TV", "45", stm);
        adicionarVariavel("Radio", "Radio bateria", stm);

        con.commit();

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Rollback executado");
        con.rollback();
      }
    }

  }

  private static void adicionarVariavel(String nome, String descricao,
      PreparedStatement stm) throws SQLException {

    stm.setString(1, nome);
    stm.setString(2, descricao);

//    if (nome.equals("Radio")) {
//      throw new RuntimeException("Não foi possivel adicionar o produto");
//    }

    stm.execute();

    try (ResultSet rst = stm.getGeneratedKeys()) {
      while (rst.next()) {
        Integer id = rst.getInt(1);
        System.out.println("O ID criado foi : " + id);
      }
    }

  }
}
