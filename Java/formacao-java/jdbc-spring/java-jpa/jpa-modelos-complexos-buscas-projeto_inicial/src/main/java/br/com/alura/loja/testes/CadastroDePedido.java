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
public class CadastroDePedido {

  public static void main(String[] args) {

    popularBancoDados();

    EntityManager em = JPAUtil.getEntityManager();
    ProdutoDao produtoDao = new ProdutoDao(em);
    PedidoDao pedidoDao = new PedidoDao(em);
    ClienteDao clienteDao = new ClienteDao(em);

    Produto produto = produtoDao.buscarPorId(1l);
    Cliente cliente = clienteDao.buscarPorId(1l);

    Pedido pedido = new Pedido(cliente);
    pedido.adicionarItem(new ItemPedido(10, pedido, produto));

    em.getTransaction().begin();

    pedidoDao.cadastrar(pedido);

    em.getTransaction().commit();

    BigDecimal totalVendido = pedidoDao.valorTotalVendido();
    System.out.println("\nTOTAL VENDIDO: " + totalVendido);

    em.close();

  }

  private static void popularBancoDados() {
    EntityManager em = JPAUtil.getEntityManager();

    Categoria celulares = new Categoria("CELULARES");
    Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

    ProdutoDao produtoDao = new ProdutoDao(em);
    CategoriaDao categoriaDao = new CategoriaDao(em);

    Cliente cliente = new Cliente("Jairo", "123456");
    ClienteDao clienteDao = new ClienteDao(em);

    em.getTransaction().begin();

    categoriaDao.cadastrar(celulares);
    produtoDao.cadastrar(celular);
    clienteDao.cadastrar(cliente);

    em.getTransaction().commit();
    em.close();
  }
}
