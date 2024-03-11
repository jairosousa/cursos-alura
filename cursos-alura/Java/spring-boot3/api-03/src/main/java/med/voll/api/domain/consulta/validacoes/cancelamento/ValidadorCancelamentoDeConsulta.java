package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.DadosCancelamentoConsulta;

/**
 * @Autor Jairo Nascimento
 * @Created 08/03/2024 - 08:55
 */
public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
