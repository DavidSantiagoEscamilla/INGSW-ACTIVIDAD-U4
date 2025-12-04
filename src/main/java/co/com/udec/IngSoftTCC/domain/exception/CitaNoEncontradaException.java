package co.com.udec.IngSoftTCC.domain.exception;

public class CitaNoEncontradaException extends RuntimeException {
    public CitaNoEncontradaException(Long id) {
        super("Cita no encontrada para la ID: " + id);
    }
}
