package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {

		String nome = "Alura";// Objeto literal
//		String outro = new String("Alura"); não recomendavel

//		char a = 'A';
//		char d = 'a';
//
//		String outra = nome.replace(a, d);

//		nome.toLowerCase();

//		outra = outra.toUpperCase();
		
//		char c = nome.charAt(2);
//		System.out.println(c);

//		System.out.println(nome);
//		System.out.println(outra);
		
//		int pos = nome.indexOf("ur");
//		System.out.println(pos);
		
//		String sub = nome.substring(1);
//		System.out.println(sub);
		
//		System.out.println(nome.length());
		
//		for (int i = 0; i < nome.length(); i++) {
//			System.out.println(nome.charAt(i));
//		}
		
//		String vazio = " ";
		
//		System.out.println(vazio.trim().isEmpty());
		
		String outra = "             alura          ";
		System.out.println(outra.trim());
		
		System.out.println(outra.contains("lu"));
		

	}

}
