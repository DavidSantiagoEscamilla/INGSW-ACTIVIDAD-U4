package co.com.udec.IngSoftTCC.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cita_medica")
public class CitaMedicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoEntity medico;

    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String motivoCancelacion;
    private LocalDateTime fechaCancelacion;

    public enum Estado { PROGRAMADA, ATENDIDA, CANCELADA }

    public CitaMedicaEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PacienteEntity getPaciente() { return paciente; }
    public void setPaciente(PacienteEntity paciente) { this.paciente = paciente; }

    public MedicoEntity getMedico() { return medico; }
    public void setMedico(MedicoEntity medico) { this.medico = medico; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public String getMotivoCancelacion() { return motivoCancelacion; }
    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }

    public LocalDateTime getFechaCancelacion() { return fechaCancelacion; }
    public void setFechaCancelacion(LocalDateTime fechaCancelacion) { this.fechaCancelacion = fechaCancelacion; }
}
