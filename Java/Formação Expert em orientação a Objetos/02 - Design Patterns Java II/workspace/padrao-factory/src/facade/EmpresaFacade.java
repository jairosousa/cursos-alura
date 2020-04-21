package facade;

public class EmpresaFacade {

    /**
     * Esse padrão de projeto, que provê uma "fachada"
     * para os serviços disponibilizados pelos sub-sistemas,
     * é conhecido pelo nome de Façade.
     */

    public EmpresaFacade() {
    }

    public Cliente buscaCliente(String cpf) {
        return new ClienteDao().buscaPorCpf(cpf);
    }

    public Fatura criaFatura(Cliente cliente, double valor) {
        Fatura fatura = new Fatura(cliente, valor);
        return fatura;
    }

    public Cobranca geraCobranca(Fatura fatura) {
        Cobranca cobranca = new Cobranca(Tipo.BOLETO, fatura);
        cobranca.emite();

        return cobranca;
    }

    public ContatoCliente fazContato(Cliente cliente, Cobranca cobranca) {
        ContatoCliente contato = new ContatoCliente(cliente, cobranca);
        contato.dispara();

        return contato;
    }
}
