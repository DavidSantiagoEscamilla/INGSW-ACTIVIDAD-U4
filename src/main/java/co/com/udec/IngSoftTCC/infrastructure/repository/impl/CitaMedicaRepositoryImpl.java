package co.com.udec.IngSoftTCC.infrastructure.repository.impl;

import co.com.udec.IngSoftTCC.domain.model.CitaMedica;
import co.com.udec.IngSoftTCC.domain.repository.CitaMedicaDomainRepository;
import co.com.udec.IngSoftTCC.infrastructure.entity.CitaMedicaEntity;
import co.com.udec.IngSoftTCC.infrastructure.mapper.CitaMedicaMapper;
import co.com.udec.IngSoftTCC.infrastructure.repository.CitaMedicaRepository;
import org.springframework.context.annotation.Lazy; // <--- ESTO ES VITAL
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CitaMedicaRepositoryImpl implements CitaMedicaDomainRepository {

    private final CitaMedicaRepository repository;
    private final CitaMedicaMapper mapper;

    // AQUI ESTÁ EL FIX: @Lazy rompe el ciclo infinito
    public CitaMedicaRepositoryImpl(@Lazy CitaMedicaRepository repository, CitaMedicaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CitaMedica guardar(CitaMedica cita) {
        CitaMedicaEntity entity = mapper.toEntity(cita);
        CitaMedicaEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CitaMedica> buscarPorId(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<CitaMedica> listarTodas() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}