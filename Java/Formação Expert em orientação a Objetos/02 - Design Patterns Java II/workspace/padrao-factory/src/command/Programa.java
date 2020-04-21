package command;

public class Programa {

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("Silvana", 150.0);
        Pedido pedido2 = new Pedido("Jairo Filho", 250.0);

        FilaDeTrabalho fila = new FilaDeTrabalho();

        fila.adiciona(new PagaPedido(pedido1));
        fila.adiciona(new PagaPedido(pedido2));
        fila.adiciona(new FinalizaiPedido(pedido1));
        fila.processa();

        /**
         * Pronto. Agora temos uma fila,
         * que executa comandos em cima dos nossos pedidos.
         * E executá-los ficou fácil. Criar novos comandos também é fácil.
         */

        /**
         * O nome desse padrão de projeto, que facilita a criação de comandos,
         * chama-se Command. Usamos ele quando temos que separar os comandos
         * que serão executados do objeto que ele pertence.
         * Um bom exemplo disso é o uso de filas de trabalho.
         */

    }
}
