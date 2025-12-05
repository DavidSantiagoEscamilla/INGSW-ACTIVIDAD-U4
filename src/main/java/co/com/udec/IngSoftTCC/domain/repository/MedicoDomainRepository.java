package co.com.udec.IngSoftTCC.domain.repository;

import co.com.udec.IngSoftTCC.domain.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoDomainRepository {
    Medico guardar(Medico medico);
    Optional<Medico> buscarPorId(Long id);
    List<Medico> listarTodos();
    void eliminar(Long id);
}
