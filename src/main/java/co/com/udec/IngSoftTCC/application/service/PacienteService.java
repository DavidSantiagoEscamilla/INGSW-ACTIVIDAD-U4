package co.com.udec.IngSoftTCC.application.service;

import co.com.udec.IngSoftTCC.domain.model.Paciente;
import co.com.udec.IngSoftTCC.domain.repository.PacienteDomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteDomainRepository pacienteRepo;

    public PacienteService(PacienteDomainRepository pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepo.listarTodos();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + id));
    }

    public Paciente crear(Paciente paciente) {
        return pacienteRepo.guardar(paciente);
    }

    public Paciente actualizar(Long id, Paciente datos) {
        Paciente existente = buscarPorId(id);

        // usa el método del domain model para actualizar
        existente.actualizarDatos(datos.getNombre(), datos.getTelefono(), datos.getCorreo());

        return pacienteRepo.guardar(existente);
    }

    public void eliminar(Long id) {
        if (pacienteRepo.buscarPorId(id).isEmpty()) {
            throw new RuntimeException("No se puede eliminar. Paciente no encontrado: " + id);
        }
        pacienteRepo.eliminar(id);
    }
}
