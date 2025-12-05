package co.com.udec.IngSoftTCC.domain.repository;

import co.com.udec.IngSoftTCC.domain.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteDomainRepository {
    Paciente guardar(Paciente paciente);
    Optional<Paciente> buscarPorId(Long id);
    List<Paciente> listarTodos();
    void eliminar(Long id);
}
