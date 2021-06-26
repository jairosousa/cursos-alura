package br.alura.jdbc.main;

import br.alura.jdbc.dao.CategoriaDao;
import br.alura.jdbc.dao.ConnectionFactory;
import br.alura.jdbc.modelo.Categoria;
import br.alura.jdbc.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Jairo Nascimento on 25/06/2021 - 20:07
 */
public class TestaListagemCategorias {

  public static void main(String[] args) throws SQLException {

    try (Connection conn = new ConnectionFactory().recuperaConexao()) {
      CategoriaDao categoriaDao = new CategoriaDao(conn);
      List<Categoria> categorias = categoriaDao.listarComProduto();
      categorias.stream()
          .forEach(c -> {
            System.out.println(c);
            for (Produto p : c.getProdutos()) {
              System.out.println(" " + p);
            }
          });
    }
  }

}
