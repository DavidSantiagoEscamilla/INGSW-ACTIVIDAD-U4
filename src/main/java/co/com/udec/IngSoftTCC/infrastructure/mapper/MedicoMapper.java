package co.com.udec.IngSoftTCC.infrastructure.mapper;

import co.com.udec.IngSoftTCC.domain.model.Medico;
import co.com.udec.IngSoftTCC.infrastructure.entity.MedicoEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    public MedicoEntity toEntity(Medico medico) {
        MedicoEntity entity = new MedicoEntity();
        entity.setId(medico.getId());
        entity.setNombre(medico.getNombre());
        entity.setEspecialidad(medico.getEspecialidad());
        entity.setActivo(medico.isActivo());
        return entity;
    }

    public Medico toDomain(MedicoEntity entity) {
        return  new Medico(
                entity.getId(),
                entity.getNombre(),
                entity.getEspecialidad(),
                entity.isActivo()
        );
    }
}
