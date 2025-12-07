package co.com.udec.IngSoftTCC.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PacienteDTO(
        Long id,
        @NotBlank(message = "Nombre es obligatorio")
        @Size(max = 200)
        String nombre,
        @NotBlank(message = "Identificación es obligatoria")
        String identificacion,
        @NotBlank(message = "Teléfono es obligatorio")
        String telefono,
        @NotBlank(message = "Correo es obligatorio")
        @Email(message = "Correo inválido")
        String correo
) {}
