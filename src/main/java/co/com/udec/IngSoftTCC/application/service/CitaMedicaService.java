package co.com.udec.IngSoftTCC.application.service;

import co.com.udec.IngSoftTCC.application.dto.CitaMedicaDTO;
import co.com.udec.IngSoftTCC.domain.model.CitaMedica;
import co.com.udec.IngSoftTCC.domain.model.Medico;
import co.com.udec.IngSoftTCC.domain.model.Paciente;
import co.com.udec.IngSoftTCC.domain.repository.CitaMedicaDomainRepository;
import co.com.udec.IngSoftTCC.domain.repository.MedicoDomainRepository;
import co.com.udec.IngSoftTCC.domain.repository.PacienteDomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaMedicaService {

    private final CitaMedicaDomainRepository repository;
    private final PacienteDomainRepository pacienteRepo;
    private final MedicoDomainRepository medicoRepo;

    public CitaMedicaService(
            CitaMedicaDomainRepository repository,
            PacienteDomainRepository pacienteRepo,
            MedicoDomainRepository medicoRepo
    ) {
        this.repository = repository;
        this.pacienteRepo = pacienteRepo;
        this.medicoRepo = medicoRepo;
    }

    public CitaMedicaDTO crear(CitaMedicaDTO dto) {

        Paciente paciente = pacienteRepo.buscarPorId(dto.pacienteId()).orElseThrow();
        Medico medico = medicoRepo.buscarPorId(dto.medicoId()).orElseThrow();

        CitaMedica cita = new CitaMedica(
                dto.id(),
                paciente,
                medico,
                dto.fechaHora()
        );

        if (dto.estado() != null)
            cita.setEstado(CitaMedica.Estado.valueOf(dto.estado()));

        cita.setMotivoCancelacion(dto.motivoCancelacion());
        cita.setFechaCancelacion(dto.fechaCancelacion());

        CitaMedica saved = repository.guardar(cita);

        return new CitaMedicaDTO(
                saved.getId(),
                saved.getPaciente().getId(),
                saved.getMedico().getId(),
                saved.getFechaHora(),
                saved.getEstado().name(),
                saved.getMotivoCancelacion(),
                saved.getFechaCancelacion()
        );
    }

    public CitaMedicaDTO buscar(Long id) {
        return repository.buscarPorId(id)
                .map(c -> new CitaMedicaDTO(
                        c.getId(),
                        c.getPaciente().getId(),
                        c.getMedico().getId(),
                        c.getFechaHora(),
                        c.getEstado().name(),
                        c.getMotivoCancelacion(),
                        c.getFechaCancelacion()
                ))
                .orElse(null);
    }

    public List<CitaMedicaDTO> listar() {
        return repository.listarTodas()
                .stream()
                .map(c -> new CitaMedicaDTO(
                        c.getId(),
                        c.getPaciente().getId(),
                        c.getMedico().getId(),
                        c.getFechaHora(),
                        c.getEstado().name(),
                        c.getMotivoCancelacion(),
                        c.getFechaCancelacion()
                ))
                .toList();
    }

    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
