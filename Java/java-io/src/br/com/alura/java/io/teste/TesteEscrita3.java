package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TesteEscrita3 {

	public static void main(String[] args) throws IOException {

		// Fluxo de saida com arquivos
//		OutputStream fos = new FileOutputStream("lorem2.txt");// Arquivo destino o arquivo
//		Writer osw = new OutputStreamWriter(fos); // Escreve arquivo e transforma bit/bytes em caracteres
//		BufferedWriter bw  = new BufferedWriter(osw); //Escreve e salva caracteres de uma linha
		
//		BufferedWriter bw  = new BufferedWriter(new FileWriter("lorem2.txt"));
		
//		PrintStream ps = new PrintStream("lorem2.txt");
		PrintWriter ps = new PrintWriter("lorem2.txt");
		
		ps.println("Escrevendo em um arquivo na primeira linha");

		ps.println();
		
		ps.println("Escrevendo em um arquivo na segunda linha");
		
		ps.close();
	}

}
