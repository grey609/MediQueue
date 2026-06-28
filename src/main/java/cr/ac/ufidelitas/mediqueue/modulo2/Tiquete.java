package cr.ac.ufidelitas.mediqueue.modulo2;

import java.time.LocalDateTime;

public class Tiquete {

    private int id;
    private String nombre;
    private String identificacion;
    private int edad;
    private String tipoSeguro;

    // CAMPOS DEL ENUNCIADO
    private String prioridad;     // Critico, Urgente, Regular, Control
    private String tipoAtencion;  // C, S, E
    private String tipoPaciente;  // P o N

    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaAtencion;

    // CONSTRUCTOR BASADO EN POLIMORFISMO (Paciente)
    public Tiquete(Paciente paciente, String tipoAtencion) {

        this.id = paciente.id;
        this.nombre = paciente.nombre;
        this.identificacion = paciente.identificacion;
        this.edad = paciente.edad;
        this.tipoSeguro = paciente.tipoSeguro;

        // desde polimorfismo
        this.tipoPaciente = paciente.getTipoPaciente();
        this.prioridad = mapearPrioridad(paciente.getNivelPrioridad());

        this.tipoAtencion = tipoAtencion;

        // fechas automáticas
        this.fechaIngreso = LocalDateTime.now();
        this.fechaAtencion = null; // equivale a -1
    }

    // MAPEO DE PRIORIDAD NUMÉRICA → TEXTO
    private String mapearPrioridad(int nivel) {
        switch (nivel) {
            case 1: return "Critico";
            case 2: return "Urgente";
            case 3: return "Regular";
            default: return "Control";
        }
    }

    // GETTERS CLAVE (IMPORTANTE)

    public String getPrioridad() {
        return prioridad;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDateTime getFechaAtencion() {
        return fechaAtencion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // VALIDACIÓN COMPLETA DEL ENUNCIADO
    public boolean esValido() {

        if (id <= 0) return false;
        if (nombre == null || nombre.isEmpty()) return false;
        if (identificacion == null || identificacion.isEmpty()) return false;
        if (edad <= 0) return false;
        if (tipoSeguro == null || tipoSeguro.isEmpty()) return false;

        if (!prioridad.matches("Critico|Urgente|Regular|Control")) return false;
        if (!tipoAtencion.matches("C|S|E")) return false;
        if (!tipoPaciente.matches("P|N")) return false;

        return true;
    }

    // MARCAR ATENCIÓN (para módulo 1.2)
    public void atender() {
        this.fechaAtencion = LocalDateTime.now();
    }

    // PRINT PARA DEBUG / DEFENSA
    @Override
    public String toString() {
        return "Tiquete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", tipoPaciente='" + tipoPaciente + '\'' +
                ", tipoAtencion='" + tipoAtencion + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaAtencion=" + fechaAtencion +
                '}';
    }
}