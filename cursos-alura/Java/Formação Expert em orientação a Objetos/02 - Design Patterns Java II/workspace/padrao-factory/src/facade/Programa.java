package facade;

import facade.sinleton.EmpresaFacadeSingleton;

public class Programa {

    public static void main(String[] args) {
        EmpresaFacade fachada = new EmpresaFacadeSingleton().getInstancia();

        String cpf = "123";
        double valor = 0;
        Cliente cliente = new Cliente(cpf);

        fachada.buscaCliente(cpf);


        Fatura fatura = fachada.criaFatura(cliente,valor);
        Cobranca cobranca = new Cobranca(Tipo.BOLETO, fatura);

        ContatoCliente contato = fachada.fazContato(cliente, cobranca);
        contato.dispara();
    }
}
