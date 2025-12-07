package co.com.udec.IngSoftTCC.application.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CitaMedicaDTO(
        Long id,

        @NotNull(message = "El ID del paciente es obligatorio")
        Long pacienteId,

        @NotNull(message = "El ID del médico es obligatorio")
        Long medicoId,

        @NotNull(message = "La fecha y hora de la cita son obligatorias")
        LocalDateTime fechaHora,

        String estado,
        String motivoCancelacion,
        LocalDateTime fechaCancelacion
) {
}