package facade;

public class ContatoCliente {
    
    Cliente cliente;
    
    Cobranca cobranca;

    public ContatoCliente(Cliente cliente, Cobranca cobranca) {
        this.cliente = cliente;
        this.cobranca = cobranca;
    }

    public void dispara() {
    }
}
