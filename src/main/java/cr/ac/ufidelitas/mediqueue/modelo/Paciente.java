
package cr.ac.ufidelitas.mediqueue.modelo;

import java.time.LocalDateTime;

/**
 * Clase Paciente (Tiquete)
 */
public class Paciente {
//Encapsulamiento
    private int id;
    private String nombre;
    private String identificacion;
    private int edad;
    private String tipoSeguro;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaAtencion;
    private String prioridad;
    private String tipoAtencion;
    private String tipoUsuario;

    // Constructor vacío
    public Paciente() {
    }

    //Constructor lleno
    public Paciente(int id, String nombre, String identificacion, int edad,
                    String tipoSeguro, String prioridad,
                    String tipoAtencion, String tipoUsuario) {

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.tipoSeguro = tipoSeguro;
        this.prioridad = prioridad;
        this.tipoAtencion = tipoAtencion;
        this.tipoUsuario = tipoUsuario;
        this.fechaIngreso = LocalDateTime.now();
        this.fechaAtencion = null;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDateTime fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(String tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // ✅ toString (para imprimir en consola)
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", tipoAtencion='" + tipoAtencion + '\'' +
                '}';
    }
}
