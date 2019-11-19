package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;

public class AvaliadorTest {
	
	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@Before
	public void setUp() {
		this.leiloeiro  = new Avaliador();
		this.joao = new Usuario("joão");
		this.jose = new Usuario("jose");
		this.maria = new Usuario("maria");
		System.out.println("inicio");
	}
	
	@After
	public void finaliza() {
	  System.out.println("fim");
	}
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}

	@Test
	public void deveEntederLancesEmOrdemCrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 250.0)
				.lance(jose, 300.0)
				.lance(maria, 400.0)
				.constroi();

		leiloeiro.avalia(leilao);

		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		double mediaEsperado = 316.66;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		assertEquals(mediaEsperado, leiloeiro.getMedia(), 0.01);
	}
	
	@Test
	public void deveEntederLancesEmValoresRandomicos() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 200.0)
				.lance(jose, 450.0)
				.lance(maria, 120.0)
				.lance(jose, 700.0)
				.lance(joao, 630.0)
				.lance(maria, 230.0)
				.constroi();

		leiloeiro.avalia(leilao);

		double maiorEsperado = 700.0;
		double menorEsperado = 120.0;
		

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntederLeilaoComApenasUmLance() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 1000.0)
				.constroi();

		leiloeiro.avalia(leilao);

		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void testaMediaDeZeroLance() {

		// cenario

		// acao
		Leilao leilao = new Leilao("Iphone 7");

		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);

		// validacao
		assertEquals(0, avaliador.getMedia(), 0.0001);

	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores= leiloeiro.getTresMaioresLance();
		
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
		
	} 
	
	@Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaioresLance();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
       
    	Leilao leilao = new Leilao("Playstation 3 Novo");

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaioresLance();

        assertEquals(0D, maiores.size(), 0.01);
    }

}
