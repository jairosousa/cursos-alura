package br.com.alura.loja.main;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 09:11
 */
public class CadastroDeProdutos {

  public static void main(String[] args) {

    Categoria celulares = new Categoria("Celulares");

    Produto celular =
        new Produto("Xiaomi redmi","Muito legal",new BigDecimal("800"), celulares);

    EntityManager em = JPAUtil.getEntityManager();

    ProdutoDao produtoDao = new ProdutoDao(em);
    CategoriaDao categoriaDao = new CategoriaDao(em);

    em.getTransaction().begin();
    categoriaDao.cadastrar(celulares);
    produtoDao.cadastrar(celular);
    em.getTransaction().commit();
    em.close();
  }
}
