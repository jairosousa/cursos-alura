package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {
		// Fluxo de entrada com arquivos
		
		InputStream fis = new FileInputStream("lorem.txt");// Carrega o arquivo
		Reader isr = new InputStreamReader(fis, "UTF-8"); // Ler arquivo e transforma bit/bytes em caracteres
		BufferedReader br = new BufferedReader(isr); //Ler e sava caracteres de uma linha

		String linha = br.readLine();
		
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		
		br.close();
	}

}
