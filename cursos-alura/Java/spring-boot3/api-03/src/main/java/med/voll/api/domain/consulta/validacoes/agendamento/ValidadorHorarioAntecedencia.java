package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 07/03/2024 - 17:31
 */

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if ((diferencaEmMinutos < 30)) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia minima de 30 monutos");
        }
    }
}
