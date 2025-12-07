package co.com.udec.IngSoftTCC.infrastructure.repository.impl;

import co.com.udec.IngSoftTCC.domain.model.Medico;
import co.com.udec.IngSoftTCC.domain.repository.MedicoDomainRepository;
import co.com.udec.IngSoftTCC.infrastructure.entity.MedicoEntity;
import co.com.udec.IngSoftTCC.infrastructure.mapper.MedicoMapper;
import co.com.udec.IngSoftTCC.infrastructure.repository.MedicoRepository;
import org.springframework.context.annotation.Lazy; // <--- IMPORTANTE
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MedicoRepositoryImpl implements MedicoDomainRepository {

    private final MedicoRepository repository;
    private final MedicoMapper mapper;

    // AQUI EL FIX: @Lazy agregado
    public MedicoRepositoryImpl(@Lazy MedicoRepository repository, MedicoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Medico guardar(Medico medico) {
        MedicoEntity entity = mapper.toEntity(medico);
        MedicoEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Medico> buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Medico> listarTodos() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}