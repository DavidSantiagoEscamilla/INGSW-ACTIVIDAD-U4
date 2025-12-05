package co.com.udec.IngSoftTCC.infrastructure.mapper;

import co.com.udec.IngSoftTCC.domain.model.CitaMedica;
import co.com.udec.IngSoftTCC.infrastructure.entity.CitaMedicaEntity;
import org.springframework.stereotype.Component;

@Component
public class CitaMedicaMapper {

    private final PacienteMapper pacienteMapper;
    private final MedicoMapper medicoMapper;

    public CitaMedicaMapper(PacienteMapper pacienteMapper, MedicoMapper medicoMapper) {
        this.pacienteMapper = pacienteMapper;
        this.medicoMapper = medicoMapper;
    }

    public CitaMedicaEntity toEntity(CitaMedica cita){
        CitaMedicaEntity entity = new CitaMedicaEntity();

        entity.setId(cita.getId());
        entity.setPaciente(pacienteMapper.toEntity(cita.getPaciente()));
        entity.setMedico(medicoMapper.toEntity(cita.getMedico()));
        entity.setFechaHora(cita.getFechaHora());
        entity.setEstado(CitaMedicaEntity.Estado.valueOf(cita.getEstado().name()));
        entity.setMotivoCancelacion(cita.getMotivoCancelacion());
        entity.setFechaCancelacion(cita.getFechaCancelacion());

        return entity;
    }

    public CitaMedica toDomain(CitaMedicaEntity entity) {

        CitaMedica domain = new CitaMedica(
                entity.getId(),
                pacienteMapper.toDomain(entity.getPaciente()),
                medicoMapper.toDomain(entity.getMedico()),
                entity.getFechaHora()
        );

        // conservar estado real
        domain.setEstado(CitaMedica.Estado.valueOf(entity.getEstado().name()));

        // si está cancelada, restaurar datos
        domain.setMotivoCancelacion(entity.getMotivoCancelacion());
        domain.setFechaCancelacion(entity.getFechaCancelacion());

        return domain;
    }
}
