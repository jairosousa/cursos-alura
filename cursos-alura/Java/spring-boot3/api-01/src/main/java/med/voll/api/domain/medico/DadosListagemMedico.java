package med.voll.api.domain.medico;

/**
 * @Autor Jairo Nascimento
 * @Created 04/03/2024 - 16:40
 */
public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
