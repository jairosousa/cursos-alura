package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteEncondingEEnconding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String c = "Ç";
		System.out.println(c.codePointAt(0));// Unicode
		
		Charset charset = Charset.defaultCharset();
//		System.out.println(charset.displayName());
		
		byte[] bytes = c.getBytes("windows-1252");
		System.out.print(bytes.length + ", " + "windows-1252 ");
		String sNovo = new String(bytes);
		System.out.println(sNovo);
		
		bytes = c.getBytes("UTF-16");
		System.out.print(bytes.length + ", " + "UTF-16 ");
		sNovo = new String(bytes, "UTF-16");
		System.out.println(sNovo);
		
		bytes = c.getBytes("UTF-8");
		System.out.print(bytes.length + ", " + "UTF-8 ");
		sNovo = new String(bytes, "UTF-8");
		System.out.println(sNovo);
		
		bytes = c.getBytes(StandardCharsets.US_ASCII);
		System.out.print(bytes.length + ", " + "US_ASCII ");
		sNovo = new String(bytes, StandardCharsets.US_ASCII);
		System.out.println(sNovo);
		
		Charset utf8 = StandardCharsets.UTF_8;
		String s1 = "13º Órgão Oficial";
		bytes = s1.getBytes(utf8);
		String s2 = new String(bytes, "UTF-8");
		System.out.println(s2);
	}

}
