package co.com.udec.IngSoftTCC.domain.model;

import co.com.udec.IngSoftTCC.domain.model.Paciente;
import co.com.udec.IngSoftTCC.domain.model.Medico;

import java.time.LocalDateTime;

public class CitaMedica {

    public enum Estado { PROGRAMADA, ATENDIDA, CANCELADA }

    private Long id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fechaHora;
    private Estado estado;
    private String motivoCancelacion;
    private LocalDateTime fechaCancelacion;

    public CitaMedica(Long id, Paciente paciente, Medico medico, LocalDateTime fechaHora) {

        if (paciente == null)
            throw new IllegalArgumentException("La cita requiere un paciente existente");

        if (medico == null || !medico.isActivo())
            throw new IllegalArgumentException("El médico debe existir y estar activo");

        if (fechaHora == null)
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");

        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.estado = Estado.PROGRAMADA;
    }

    public Long getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public Estado getEstado() { return estado; }
    public String getMotivoCancelacion() { return motivoCancelacion; }
    public LocalDateTime getFechaCancelacion() { return fechaCancelacion; }

    public void actualizar(LocalDateTime nuevaFechaHora, Medico nuevoMedico) {
        if (estado != Estado.PROGRAMADA)
            throw new IllegalStateException("No se puede actualizar una cita atendida o cancelada");

        if (nuevaFechaHora == null)
            throw new IllegalArgumentException("La fecha no puede ser nula");

        if (nuevoMedico == null || !nuevoMedico.isActivo())
            throw new IllegalArgumentException("El médico debe estar activo");

        this.fechaHora = nuevaFechaHora;
        this.medico = nuevoMedico;
    }

    public void cancelar(String motivo) {
        if (estado != Estado.PROGRAMADA)
            throw new IllegalStateException("Solo se puede cancelar una cita programada");

        if (motivo == null || motivo.isBlank())
            throw new IllegalArgumentException("Debe indicar un motivo de cancelación");

        this.estado = Estado.CANCELADA;
        this.motivoCancelacion = motivo;
        this.fechaCancelacion = LocalDateTime.now();
    }
}
