package facade.sinleton;

import facade.EmpresaFacade;

public class EmpresaFacadeSingleton {
    /**
     * A implementação abaixo é o que chamamos de Singleton.
     * Ele faz com que só exista uma única instância da classe em todo o sistema!
     */

    private static EmpresaFacade instancia;

    public EmpresaFacade getInstancia() {
        if(instancia == null) {
            instancia = new EmpresaFacade();
        }

        return instancia;
    }
}
