package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @Autor Jairo Nascimento
 * @Created 04/03/2024 - 13:58
 */
public record DadosEndereco(
        @NotBlank
        String logradouro,
        String numero,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento
) {
}
