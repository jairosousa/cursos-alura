package med.voll.api.domain;

/**
 * @Autor Jairo Nascimento
 * @Created 07/03/2024 - 15:30
 */
public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
