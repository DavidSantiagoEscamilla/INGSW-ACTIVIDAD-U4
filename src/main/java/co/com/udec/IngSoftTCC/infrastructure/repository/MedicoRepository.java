package co.com.udec.IngSoftTCC.infrastructure.repository;

import co.com.udec.IngSoftTCC.infrastructure.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MedicoRepository extends JpaRepository<MedicoEntity,Long> {
    // opcional: buscar solo medicos activos
    // List<MedicoEntity> findByActivoTrue();
}
