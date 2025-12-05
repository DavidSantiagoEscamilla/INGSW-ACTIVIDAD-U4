package co.com.udec.IngSoftTCC.domain.model;

public class Paciente {

    private Long id;
    private String nombre;
    private String identificacion;
    private String telefono;
    private String correo;

    public Paciente(Long id, String nombre, String identificacion, String telefono, String correo) {
        validarObligatorios(nombre, identificacion, telefono, correo);

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
    }

    private void validarObligatorios(String nombre, String identificacion, String telefono, String correo) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");

        if (identificacion == null || identificacion.isBlank())
            throw new IllegalArgumentException("La identificación no puede estar vacía");

        if (telefono == null || telefono.isBlank())
            throw new IllegalArgumentException("El teléfono no puede estar vacío");

        if (correo == null || correo.isBlank())
            throw new IllegalArgumentException("El correo no puede estar vacío");
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }

    public void actualizarDatos(String nombre, String telefono, String correo) {
        validarObligatorios(nombre, this.identificacion, telefono, correo);
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
}
