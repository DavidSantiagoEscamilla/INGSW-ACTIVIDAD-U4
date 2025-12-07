package co.com.udec.IngSoftTCC.domain.repository;

import co.com.udec.IngSoftTCC.domain.model.CitaMedica;

import java.util.List;
import java.util.Optional;

public interface CitaMedicaDomainRepository {

    CitaMedica guardar(CitaMedica cita);

    Optional<CitaMedica> buscarPorId(Long id);

    List<CitaMedica> listarTodas();

    void eliminar(Long id);
}
