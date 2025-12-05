package co.com.udec.IngSoftTCC.infrastructure.controller;

import co.com.udec.IngSoftTCC.domain.model.Medico;
import co.com.udec.IngSoftTCC.domain.repository.MedicoDomainRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoDomainRepository repository;

    public MedicoController(MedicoDomainRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Medico> listarTodos() {
        return repository.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        return repository.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medico crear(@RequestBody Medico medico) {
        return repository.guardar(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Long id, @RequestBody Medico medico) {
        return repository.buscarPorId(id)
                .map(existing -> {
                    medico.setId(id); // asegurar que use el mismo id
                    return ResponseEntity.ok(repository.guardar(medico));
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
