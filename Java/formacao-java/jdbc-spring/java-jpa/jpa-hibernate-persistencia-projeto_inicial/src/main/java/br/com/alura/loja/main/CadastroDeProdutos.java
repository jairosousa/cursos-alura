package br.com.alura.loja.main;

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
    Produto celular =
        new Produto("Xiaomi redmi","Muito legal",new BigDecimal("800"), Categoria.CELULARES);

    EntityManager em = JPAUtil.getEntityManager();

    ProdutoDao dao = new ProdutoDao(em);
    em.getTransaction().begin();
    dao.cadastrar(celular);
    em.getTransaction().commit();
    em.close();
  }
}
