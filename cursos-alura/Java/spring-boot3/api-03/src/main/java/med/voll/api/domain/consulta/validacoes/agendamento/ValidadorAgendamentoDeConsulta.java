package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

/**
 * @Autor Jairo Nascimento
 * @Created 07/03/2024 - 18:05
 */
public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
