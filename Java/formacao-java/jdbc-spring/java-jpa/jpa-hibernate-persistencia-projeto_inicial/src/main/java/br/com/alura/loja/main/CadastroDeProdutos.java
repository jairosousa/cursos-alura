package br.com.alura.loja.main;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 09:11
 */
public class CadastroDeProdutos {

  public static void main(String[] args) {

    cadastroProduto();

    EntityManager em = JPAUtil.getEntityManager();

    ProdutoDao produtoDao = new ProdutoDao(em);
    Produto produto = produtoDao.buscaPorId(1l);
    System.out.println(produto.getNome() + "/" + produto.getPreco());

    List<Produto> todos = produtoDao.buscaTodos();
    todos.forEach(p1 -> System.out.println(p1.getNome()));

    System.out.println("\n----Busca por nome----");
    List<Produto> nomes = produtoDao.buscaPorNome("Xiaomi redmi");
    nomes.forEach(p1 -> System.out.println(p1.getNome()));

    System.out.println("\n----Busca por nome Categoria----");
    List<Produto> nomesCategoria = produtoDao.buscaPorNomeDaCategoria("Celulares");
    nomesCategoria.forEach(p1 -> System.out.println(p1.getNome()));

    System.out.println("\n----Buscar Preco do Produto com Nome----");
    System.out.println("PREÇO PRODUTO" + produtoDao.buscarPrecoDoProdutoComNome("Xiaomi redmi"));


  }

  private static void cadastroProduto() {
    Categoria celulares = new Categoria("Celulares");

    Produto celular =
        new Produto("Xiaomi redmi", "Muito legal", new BigDecimal("800"), celulares);

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
