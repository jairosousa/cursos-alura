
/**
 * Quem assinar esse contrato precisa implementar
 * os métodos
 * @author jairo
 *
 */
public abstract interface Autenticavel {

    public void setSenha(int senha);

    public boolean autentica(int senha);
}
