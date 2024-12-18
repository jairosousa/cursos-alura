package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {

	public static void main(String[] args) {
		
		int[] idades = new int[5];
		String[] nomes = new String[5];
		
		int idade = 29; //Integer
		Integer idadeRef = Integer.valueOf(29); //Autoboxing
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		
		System.out.println(idadeRef.doubleValue());
		
		int valor = idadeRef.intValue();//Unboxing
		
		String s = args[0];
		
//		Integer numero = Integer.valueOf(s);
		int numero = Integer.parseInt(s);
		
		System.out.println(numero);
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(29); //Autoboxing
	}

}
