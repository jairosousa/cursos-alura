package br.com.bytebank.banco.teste.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteDeserilizacao {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
		
		ContaCorrente cc = (ContaCorrente) ois.readObject();
		
		System.out.println(cc.getSaldo());
		System.out.println(cc.getTitular().getNome());

	}

}
