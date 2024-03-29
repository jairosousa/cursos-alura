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
import br.com.alura.loja.vo.RelatorioDeVendasVO;
import java.math.BigDecimal;
import java.util.List;
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

    Produto produto1 = produtoDao.buscarPorId(1l);
    Produto produto2 = produtoDao.buscarPorId(2l);
    Produto produto3 = produtoDao.buscarPorId(3l);
    Cliente cliente = clienteDao.buscarPorId(1l);

    Pedido pedido = new Pedido(cliente);
    pedido.adicionarItem(new ItemPedido(10, pedido, produto1));
    pedido.adicionarItem(new ItemPedido(20, pedido, produto2));

    Pedido pedido2 = new Pedido(cliente);
    pedido2.adicionarItem(new ItemPedido(2, pedido2, produto3));
    pedido2.adicionarItem(new ItemPedido(10, pedido2, produto2));

    Pedido pedido3 = new Pedido(cliente);
    pedido2.adicionarItem(new ItemPedido(50, pedido3, produto1));
    pedido2.adicionarItem(new ItemPedido(15, pedido3, produto3));

    em.getTransaction().begin();

    pedidoDao.cadastrar(pedido);
    pedidoDao.cadastrar(pedido2);
    pedidoDao.cadastrar(pedido3);

    em.getTransaction().commit();

    System.out.println("\n---------Usando a classe DadosPessoais Embedded com Cliente-----");
    Pedido pedidoComCliente = pedidoDao.buscaPedidoComCliente(1l);
    System.out.println(pedidoComCliente.getCliente().getDadosPessoais().getNome());

    BigDecimal totalVendido = pedidoDao.valorTotalVendido();
    System.out.println("\nTOTAL VENDIDO: " + totalVendido);

    System.out.println("\n-----Relatorio-----");
    List<RelatorioDeVendasVO> relatorioDeVendasVOS = pedidoDao.relatorioDeVendas();
    for (RelatorioDeVendasVO rel : relatorioDeVendasVOS) {
      System.out.println("PRODUTO: " + rel.getNomeProduto());
      System.out.println("QUANTIDADE VENDAS: " + rel.getQuantidadeVendida());
      System.out.println("DATA ULTIMA VENDA: " + rel.getDataUltimaVenda());
      System.out.println("---------------------------------");
    }

    em.close();

  }

  private static void popularBancoDados() {
    EntityManager em = JPAUtil.getEntityManager();

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

    em.getTransaction().begin();

    categoriaDao.cadastrar(celulares);
    categoriaDao.cadastrar(videogames);
    categoriaDao.cadastrar(informatica);

    produtoDao.cadastrar(celular);
    produtoDao.cadastrar(videogame);
    produtoDao.cadastrar(macbook);

    clienteDao.cadastrar(cliente);

    em.getTransaction().commit();
    em.close();
  }
}
