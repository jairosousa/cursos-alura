package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

/**
 * @Autor Jairo Nascimento
 * @Created 04/03/2024 - 17:28
 */
public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
