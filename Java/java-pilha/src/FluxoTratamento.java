
public class FluxoTratamento {
	public static void main(String[] args) {
		System.out.println("Ini do main");
		try {
			metodo1();
		} catch (MinhaExececao | ArithmeticException | NullPointerException ex) {
			String msg = ex.getMessage();
			System.out.println("Excption " + msg);
//			System.out.println("ArithmeticException " + ex.getMessage());
			ex.printStackTrace();
		}
		System.out.println("Fim do main");
	}

	private static void metodo1() throws MinhaExececao {
		System.out.println("Ini do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
	}

	private static void metodo2() throws MinhaExececao {
		System.out.println("Ini do metodo2");

		throw new MinhaExececao("Algo deu errado");

//		System.out.println("Fim do metodo2");
	}
}
