package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 07/03/2024 - 11:44
 */
public record DadosDetalhamentoConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data
) {
    public DadosDetalhamentoConsulta(Consulta dados) {
        this(dados.getId(), dados.getMedico().getId(),dados.getPaciente().getId(),dados.getData());
    }
}
