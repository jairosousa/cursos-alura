package br.com.caelum;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.caelum.model.Categoria;
import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Component
public class CriadorDeProdutos {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private JpaTransactionManager transactionManager;
	
	@PostConstruct
	public void init() {
		TransactionTemplate template = new TransactionTemplate(transactionManager);
		template.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				Loja casaDoCodigo = new Loja();
				casaDoCodigo.setNome("Casa do C�digo");
				
				em.persist(casaDoCodigo);
				
				Loja musicalAlegre = new Loja();
				musicalAlegre.setNome("Musical Alegre");
				
				em.persist(musicalAlegre);
				
				Categoria tecnologia = new Categoria("Tecnologia");
				em.persist(tecnologia);
				
				Categoria musica = new Categoria("Musica");
				em.persist(musica);
				
				Produto cursoDeViolao = new Produto();
				cursoDeViolao.setNome("Curso de Viol�o");
				cursoDeViolao.setLoja(musicalAlegre);
				cursoDeViolao.setPreco(49.0);
				cursoDeViolao.setDescricao("Estude com os melhores professores e aprenda no seu ritmo, sem sair de casa.");
				cursoDeViolao.adicionarCategorias(tecnologia, musica);
				cursoDeViolao.setLinkDaFoto("https://pbs.twimg.com/profile_images/378800000825434860/12136ee913ed4f44860914d44650144e.png");
				
				em.persist(cursoDeViolao);
				
				Produto livroDeArquitetura = new Produto();
				livroDeArquitetura.setNome("Introdu��o a Arquitetura Java e Design de projetos com Java");
				livroDeArquitetura.setLoja(casaDoCodigo);
				livroDeArquitetura.setPreco(30.0);
				livroDeArquitetura.adicionarCategorias(tecnologia);
				livroDeArquitetura.setDescricao("Neste livro, os autores, conhecidos especialistas da "
											   + " �rea, apresentam muitos t�picos que aparecem com frequencia"
											   + " na plataforma Java, incluindo desde modelagem e design das "
											   + "classes, d�o detalhes importantes das tecnologias mais utilizadas."
											   + "  Sempre com uma vis�o t�cnica e pr�tica capaz de elucidar muitas "
											   + "quest�es enfrentadas tanto pelo profissional iniciante quanto por "
											   + "aquele que est� adquirindo mais experi�ncia na plataforma.");
				
				livroDeArquitetura.setLinkDaFoto("http://www.arquiteturajava.com.br/img/capa-livro.png");
				
				em.persist(livroDeArquitetura);
				
				Produto livroDeSpring = new Produto();
				livroDeSpring.setNome("Vire o jogo com Spring Framework");
				livroDeSpring.setLoja(casaDoCodigo);
				livroDeSpring.setPreco(30.0);
				livroDeSpring.adicionarCategorias(tecnologia);
				livroDeSpring.setDescricao("Criado para simplificar o desenvolvimento de aplica��es Java, "
						+ "o Spring se tornou um dos frameworks de mais destaque dentro desse grande ambiente.  "
						+ "Aprenda muito mais que o b�sico do Spring, desde o tradicional Container de Invers�o "
						+ "de Controle e Inje��o de Depend�ncias, passando pelos robustos m�dulos de seguran�a, "
						+ "transa��es, programa��o orientada a aspectos e tamb�m o fant�stico m�dulo MVC, o SpringMVC.");
				
				livroDeSpring.setLinkDaFoto("http://cdn.shopify.com/s/files/1/0155/7645/products/spring-framework-featured_large.png?v=1411567960");
				
				em.persist(livroDeSpring);
				
				Produto violao = new Produto();
				violao.setNome("Viol�o");
				violao.setLoja(musicalAlegre);
				violao.setDescricao("Excelente viol�o");
				violao.setPreco(500.0);
				violao.adicionarCategorias(musica);
				violao.setLinkDaFoto("https://a-static.mlcdn.com.br/618x463/violao-classico-acustico-csr-851-39-6-cordas/vendas-rapidas/8081/9919b922c1eb8e05487ecd4f2859a07b.jpg");
				
				em.persist(violao);
				
				Produto flauta = new Produto();
				flauta.setNome("Flauta Doce");
				flauta.setLoja(musicalAlegre);
				flauta.setDescricao("Flauta doce");
				flauta.setPreco(300.0);
				flauta.adicionarCategorias(musica);
				flauta.setLinkDaFoto("http://i.mlcdn.com.br/1500x1500/flauta-doce-germanicayamaha-yrs-23g-204013000.jpg");
				
				em.persist(flauta);
				
			}
		});		
	}
	
}
