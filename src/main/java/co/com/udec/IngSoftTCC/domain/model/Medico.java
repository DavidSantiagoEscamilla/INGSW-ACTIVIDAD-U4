package co.com.udec.IngSoftTCC.domain.model;

public class Medico {

    private Long id;
    private String nombre;
    private String especialidad;
    private boolean activo;

    public Medico(Long id, String nombre, String especialidad, boolean activo) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");

        if (especialidad == null || especialidad.isBlank())
            throw new IllegalArgumentException("La especialidad no puede estar vacía");

        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public boolean isActivo() { return activo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setActivo(boolean activo) { this.activo = activo; }


    public void actualizarDatos(String nombre, String especialidad) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");

        if (especialidad == null || especialidad.isBlank())
            throw new IllegalArgumentException("La especialidad no puede estar vacía");

        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void desactivar() {
        this.activo = false;
    }
}
