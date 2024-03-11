package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

/**
 * @Autor Jairo Nascimento
 * @Created 07/03/2024 - 11:58
 */
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
    Boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);
}
