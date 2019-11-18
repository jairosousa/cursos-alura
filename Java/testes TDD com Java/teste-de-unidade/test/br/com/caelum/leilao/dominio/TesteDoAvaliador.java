package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteDoAvaliador {

	@Test
	public void deveEntederLancesEmOrdemCrescente() {
		
		 Usuario joao = new Usuario("joão");
		 Usuario jose = new Usuario("jose");
		 Usuario maria = new Usuario("maria");
		 
		 Leilao leilao = new Leilao("Playstation 3 Novo");
		 
		 leilao.propoe(new Lance(joao, 250.0));
		 leilao.propoe(new Lance(jose, 300.0));
		 leilao.propoe(new Lance(maria, 400.0));
		 
		 Avaliador leiloeiro = new Avaliador();
		 leiloeiro.avalia(leilao);
		 
		 double maiorEsperado = 400.0;
		 double menorEsperado = 250.0;
		 double mediaEsperado = 316.66;
		 
		 assertEquals(maiorEsperado,leiloeiro.getMaiorLance(), 0.0001);
		 assertEquals(menorEsperado,leiloeiro.getMenorLance(), 0.0001);
		 assertEquals(mediaEsperado,leiloeiro.getMedia(), 0.01);
	}
	
	@Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        assertEquals(0, avaliador.getMedia(), 0.0001);

    }

}
