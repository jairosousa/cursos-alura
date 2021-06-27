package br.com.alura.loja.main;

import br.com.alura.loja.modelo.Produto;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 09:11
 */
public class CadastroDeProdutos {

  public static void main(String[] args) {
    Produto celular = new Produto();
    celular.setNome("Xiaomi redmi");
    celular.setDescricao("Muito legal");
    celular.setPreco(new BigDecimal("800"));

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
    EntityManager manager = factory.createEntityManager();

    manager.getTransaction().begin();
    manager.persist(celular);
    manager.getTransaction().commit();
    manager.close();
  }
}
