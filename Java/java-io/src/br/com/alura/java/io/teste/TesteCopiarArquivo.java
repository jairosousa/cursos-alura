package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();

//		InputStream fis = new FileInputStream("lorem.txt");// Carrega o arquivo
//		InputStream fis = System.in;// Carrega do teclado
		InputStream fis = socket.getInputStream();// Carrega via socket rede
		Reader isr = new InputStreamReader(fis); // Ler arquivo e transforma bit/bytes em caracteres
		BufferedReader br = new BufferedReader(isr); // Ler e sava caracteres de uma linha

//		OutputStream fos = new FileOutputStream("lorem2.txt");// Arquivo destino o arquivo
//		OutputStream fos = System.out;// Envia para o console
		OutputStream fos = socket.getOutputStream();// Envia para rede
		Writer osw = new OutputStreamWriter(fos); // Escreve arquivo e transforma bit/bytes em caracteres
		BufferedWriter bw = new BufferedWriter(osw); // Escreve e salva caracteres de uma linha

		String linha = br.readLine();

		while (linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			bw.flush();
			linha = br.readLine();
		}

		br.close();
		bw.close();
	}

}
