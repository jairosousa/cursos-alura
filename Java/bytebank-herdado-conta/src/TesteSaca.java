
public class TesteSaca {

	public static void main(String[] args) {
		ContaCorrente c = new ContaCorrente(111, 222);
		c.deposita(200);
		try {
			c.saca(210);
		} catch (Exception e) {
			System.out.println("Execeção: " + e.getMessage());
		}
		System.out.println(c.getSaldo());
	}

}
