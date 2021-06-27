package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 09:49
 */
public class JPAUtil {

  private static final EntityManagerFactory FACTORY =  Persistence.createEntityManagerFactory("loja");

  public static EntityManager getEntityManager() {
    return FACTORY.createEntityManager();
  }

}
