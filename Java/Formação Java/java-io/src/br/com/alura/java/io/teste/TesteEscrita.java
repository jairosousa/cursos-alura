package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {

		// Fluxo de saida com arquivos
		OutputStream fos = new FileOutputStream("lorem2.txt");// Arquivo destino o arquivo
		Writer osw = new OutputStreamWriter(fos); // Escreve arquivo e transforma bit/bytes em caracteres
		BufferedWriter bw  = new BufferedWriter(osw); //Escreve e salva caracteres de uma linha

		bw.write("Escrevendo em um arquivo na primeira linha");
		bw.newLine();
//		bw.newLine();
		bw.write("Escrevendo em um arquivo na terceira linha");
		
		
		bw.close();
	}

}
