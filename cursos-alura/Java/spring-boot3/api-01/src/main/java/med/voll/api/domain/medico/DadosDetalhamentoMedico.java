package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

/**
 * @Autor Jairo Nascimento
 * @Created 05/03/2024 - 15:11
 */
public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        Endereco endereco
) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(),medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
