package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWrite {

	public static void main(String[] args) throws IOException {
		
		long ini = System.currentTimeMillis();

		// Fluxo de saida com arquivos
//		OutputStream fos = new FileOutputStream("lorem2.txt");// Arquivo destino o arquivo
//		Writer osw = new OutputStreamWriter(fos); // Escreve arquivo e transforma bit/bytes em caracteres
//		BufferedWriter bw  = new BufferedWriter(osw); //Escreve e salva caracteres de uma linha
		
		BufferedWriter bw  = new BufferedWriter(new FileWriter("lorem2.txt"));

		bw.write("Escrevendo em um arquivo na primeira linha");
//		bw.write(System.lineSeparator()); //nova linha
//		bw.write(System.lineSeparator()); //nova linha
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("Escrevendo em um arquivo na segunda linha");
		
		
		bw.close();
		
		long fim = System.currentTimeMillis();

        System.out.println("Passaram " + (fim - ini) + " milissegundos");
	}

}
