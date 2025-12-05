package co.com.udec.IngSoftTCC.infrastructure.controller;

import co.com.udec.IngSoftTCC.domain.model.Paciente;
import co.com.udec.IngSoftTCC.domain.repository.PacienteDomainRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteDomainRepository repository;

    public PacienteController(PacienteDomainRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return repository.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return repository.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return repository.guardar(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        return repository.buscarPorId(id)
                .map(existing -> {
                    paciente.setId(id); // asegurar que use el mismo id
                    return ResponseEntity.ok(repository.guardar(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (repository.buscarPorId(id).isPresent()) {
            repository.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
