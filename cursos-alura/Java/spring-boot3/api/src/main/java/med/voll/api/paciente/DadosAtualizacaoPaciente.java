package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

/**
 * @Autor Jairo Nascimento
 * @Created 05/03/2024 - 12:04
 */
public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
