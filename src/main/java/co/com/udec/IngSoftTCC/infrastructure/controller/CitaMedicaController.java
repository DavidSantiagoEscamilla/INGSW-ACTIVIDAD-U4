package co.com.udec.IngSoftTCC.infrastructure.controller;

import co.com.udec.IngSoftTCC.application.dto.CitaMedicaDTO;
import co.com.udec.IngSoftTCC.application.service.CitaMedicaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService service; // Inyectar Servicio, no Repositorio

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CitaMedicaDTO> listarTodas() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaMedicaDTO> buscarPorId(@PathVariable Long id) {
        CitaMedicaDTO dto = service.buscar(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CitaMedicaDTO> crear(@Valid @RequestBody CitaMedicaDTO citaDTO) {
        // El servicio se encarga de convertir DTO -> Entidad y guardar
        return ResponseEntity.ok(service.crear(citaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}