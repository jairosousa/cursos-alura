package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

/**
 * @Autor Jairo Nascimento
 * @Created 07/03/2024 - 16:17
 */
public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}
