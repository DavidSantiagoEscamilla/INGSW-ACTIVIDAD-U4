package co.com.udec.IngSoftTCC.application.service;

import co.com.udec.IngSoftTCC.domain.model.Medico;
import co.com.udec.IngSoftTCC.domain.repository.MedicoDomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoDomainRepository medicoRepo;

    public MedicoService(MedicoDomainRepository medicoRepo) {
        this.medicoRepo = medicoRepo;
    }

    public List<Medico> listarTodos() {
        return medicoRepo.listarTodos();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con ID: " + id));
    }

    public Medico crear(Medico medico) {
        return medicoRepo.guardar(medico);
    }

    public Medico actualizar(Long id, Medico datos) {
        Medico existente = buscarPorId(id);

        // usa el método del domain model
        existente.actualizarDatos(datos.getNombre(), datos.getEspecialidad());

        return medicoRepo.guardar(existente);
    }

    public void eliminar(Long id) {
        if (medicoRepo.buscarPorId(id).isEmpty()) {
            throw new RuntimeException("No se puede eliminar. Médico no encontrado: " + id);
        }
        medicoRepo.eliminar(id);
    }
}
