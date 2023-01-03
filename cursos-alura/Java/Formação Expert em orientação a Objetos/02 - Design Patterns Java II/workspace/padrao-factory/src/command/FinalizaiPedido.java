package command;

public class FinalizaiPedido implements Comando {

    private Pedido pedido;

    public FinalizaiPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executa() {
        System.out.println("Finalizando o pedido do cliente: " + pedido.getCliente());
        pedido.finaliza();
    }
}
