package co.com.udec.IngSoftTCC.infrastructure.repository.impl;

import co.com.udec.IngSoftTCC.domain.model.Paciente;
import co.com.udec.IngSoftTCC.domain.repository.PacienteDomainRepository;
import co.com.udec.IngSoftTCC.infrastructure.mapper.PacienteMapper;
import co.com.udec.IngSoftTCC.infrastructure.repository.PacienteRepository;
import org.springframework.context.annotation.Lazy; // <--- IMPORTANTE
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PacienteRepositoryImpl implements PacienteDomainRepository {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    // AQUI EL FIX: @Lazy agregado
    public PacienteRepositoryImpl(@Lazy PacienteRepository repository, PacienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        var entity = mapper.toEntity(paciente);
        var saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Paciente> listarTodos() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}