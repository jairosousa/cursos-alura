package br.com.alura.loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPBinding;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.research.ws.wadl.HTTPMethods;
import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

public class ClienteTest {

	private HttpServer server;
	
	private Client client;

	private WebTarget target;

	@Before
	public void startServidor() {
		server = Servidor.InicializaServidor();
		this.client = ClientBuilder.newClient();
		this.target = client.target("http://localhost:8080");

	}

	@After
	public void stopServidor() {
		server.stop();
	}

	@Test
	public void testeQueBuscaUmCarrinhoTrazOCarrinhoEsperado() {
		
		String conteudo = target.path("/carrinhos/1").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
		
	}
	
	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		
		String conteudo = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);

		assertTrue(conteudo.contains("Rua Vergueiro 3185"));

	}
	
	@Test
	public void testaAdicionarUmCarrinho() {
		
		// Criar Carrinho
		Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
        carrinho.setRua("Rua Vergueiro");
        carrinho.setCidade("Sao Paulo");
        String xml = carrinho.toXML();
        
        //Agora que temos o XML e sabemos que o media type que enviaremos é application/xml, 
        //precisamos representar isso de alguma maneira. Utilizaremos a classe Entity do próprio
        //JAX-RS, para criar tal representação
        
        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        
        assertEquals(201, response.getStatus());
        
        String location = response.getHeaderString("location");
        
        String conteudo = client.target(location).request().get(String.class);
        
        assertTrue(conteudo.contains("Tablet"));
		
	}


}
