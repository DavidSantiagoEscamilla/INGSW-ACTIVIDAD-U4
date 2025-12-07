package co.com.udec.IngSoftTCC.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MedicoDTO(
        Long id,

        @NotBlank(message = "El nombre del médico es obligatorio")
        @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
        String nombre,

        @NotBlank(message = "La especialidad es obligatoria")
        @Size(max = 100, message = "La especialidad no puede exceder los 100 caracteres")
        String especialidad,

        boolean activo
) {
}