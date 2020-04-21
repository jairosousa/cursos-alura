package facade;

public class Cobranca {

    Fatura fatura;
    Tipo tipo;

    public Cobranca(Tipo tipo, Fatura fatura) {
        this.fatura = fatura;
        this.tipo = tipo;
    }

    public void emite() {

    }
}
