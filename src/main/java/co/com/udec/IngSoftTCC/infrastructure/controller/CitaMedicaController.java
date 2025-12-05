package co.com.udec.IngSoftTCC.infrastructure.controller;

import co.com.udec.IngSoftTCC.domain.model.CitaMedica;
import co.com.udec.IngSoftTCC.domain.repository.CitaMedicaDomainRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaDomainRepository repository;

    public CitaMedicaController(CitaMedicaDomainRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CitaMedica> listarTodas() {
        return repository.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaMedica> buscarPorId(@PathVariable Long id) {
        return repository.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CitaMedica crear(@RequestBody CitaMedica cita) {
        return repository.guardar(cita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaMedica> actualizar(@PathVariable Long id, @RequestBody CitaMedica cita) {
        return repository.buscarPorId(id)
                .map(existing -> {
                    cita.setId(id); // asegurar que use el mismo id
                    return ResponseEntity.ok(repository.guardar(cita));
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
