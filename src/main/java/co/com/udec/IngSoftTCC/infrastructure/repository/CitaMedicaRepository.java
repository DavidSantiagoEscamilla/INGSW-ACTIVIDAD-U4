package co.com.udec.IngSoftTCC.infrastructure.repository;

import co.com.udec.IngSoftTCC.infrastructure.entity.CitaMedicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedicaEntity, Long> {
    // opcional: filtrar por estado
    // List<CitaMedicaEntity> findByEstado(CitaMedicaEntity.Estado estado);
}
