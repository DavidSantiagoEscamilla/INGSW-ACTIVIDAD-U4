package co.com.udec.IngSoftTCC.infrastructure.mapper;

import co.com.udec.IngSoftTCC.domain.model.Paciente;
import co.com.udec.IngSoftTCC.infrastructure.entity.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public PacienteEntity toEntity(Paciente paciente) {
        PacienteEntity entity = new PacienteEntity();
        entity.setId(paciente.getId());
        entity.setNombre(paciente.getNombre());
        entity.setIdentificacion(paciente.getIdentificacion());
        entity.setTelefono(paciente.getTelefono());
        entity.setCorreo(paciente.getCorreo());
        return entity;
    }

    public Paciente toDomain(PacienteEntity entity) {
        return new Paciente(
                entity.getId(),
                entity.getNombre(),
                entity.getIdentificacion(),
                entity.getTelefono(),
                entity.getCorreo()
        );
    }
}
