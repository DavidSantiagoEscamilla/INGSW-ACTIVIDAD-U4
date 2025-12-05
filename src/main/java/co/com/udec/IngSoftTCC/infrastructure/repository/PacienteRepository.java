package co.com.udec.IngSoftTCC.infrastructure.repository;

import co.com.udec.IngSoftTCC.infrastructure.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
    // nada
}
