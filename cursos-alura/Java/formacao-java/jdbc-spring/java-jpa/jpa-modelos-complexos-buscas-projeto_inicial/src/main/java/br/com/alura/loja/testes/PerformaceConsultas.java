package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 * @Author: Jairo Nascimento on 27/06/2021 - 15:48
 */
public class PerformaceConsultas {

  public static void main(String[] args) {

    EntityManager em = JPAUtil.getEntityManager();
    popularBancoDados(em);

    PedidoDao pedidoDao = new PedidoDao(em);

    Pedido pedido = pedidoDao.buscaPedidoComCliente(1l);
    em.close();


    System.out.println("cliente: " + pedido.getCliente());
//    pedido.getItens().forEach(System.out::println);

  }

  private static void popularBancoDados(EntityManager em) {

    Categoria celulares = new Categoria("CELULARES");
    Categoria videogames = new Categoria("VIDEOGAMES");
    Categoria informatica = new Categoria("INFORMATICA");

    Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
    Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("1800"), videogames);
    Produto macbook = new Produto("Macbook", "Macbook Pro", new BigDecimal("5000"), informatica);

    Cliente cliente = new Cliente("Jairo", "123456");

    ProdutoDao produtoDao = new ProdutoDao(em);
    CategoriaDao categoriaDao = new CategoriaDao(em);
    ClienteDao clienteDao = new ClienteDao(em);
    PedidoDao pedidoDao = new PedidoDao(em);

    Pedido pedido = new Pedido(cliente);
    pedido.adicionarItem(new ItemPedido(10, pedido, celular));
    pedido.adicionarItem(new ItemPedido(20, pedido, videogame));

    Pedido pedido2 = new Pedido(cliente);
    pedido2.adicionarItem(new ItemPedido(2, pedido2, macbook));
    pedido2.adicionarItem(new ItemPedido(10, pedido2, videogame));

    Pedido pedido3 = new Pedido(cliente);
    pedido2.adicionarItem(new ItemPedido(50, pedido3, celular));
    pedido2.adicionarItem(new ItemPedido(15, pedido3, macbook));

    em.getTransaction().begin();

    categoriaDao.cadastrar(celulares);
    categoriaDao.cadastrar(videogames);
    categoriaDao.cadastrar(informatica);

    produtoDao.cadastrar(celular);
    produtoDao.cadastrar(videogame);
    produtoDao.cadastrar(macbook);

    clienteDao.cadastrar(cliente);

    pedidoDao.cadastrar(pedido);
    pedidoDao.cadastrar(pedido2);
    pedidoDao.cadastrar(pedido3);

    em.getTransaction().commit();

  }
}
