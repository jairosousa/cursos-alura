package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 08/03/2024 - 10:00
 */
public record DadosDetalhamentoAgenda(
        Long id,
        String paciente,
        String Medico,
        Especialidade especialidade,
        LocalDateTime data,
        MotivoCancelamento motivo
) {
}
