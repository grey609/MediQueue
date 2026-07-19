package cr.ac.ufidelitas.mediqueue.modulo2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tiquete {

    // ============================================
    // DATOS DEL PACIENTE
    // ============================================
    private int id;
    private String nombre;
    private String identificacion;
    private int edad;
    private String seguro;

    // ============================================
    // DATOS DEL TIQUETE
    // ============================================
    private String fechaIngreso;
    private String fechaAtencion;

    private String prioridad;
    private String tipoAtencion;
    private String tipoPaciente;

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Constructor vacío para Gson
    public Tiquete() {
    }

    public Tiquete(
            Paciente paciente,
            String tipoAtencion,
            String prioridad) {

        this.id = paciente.getId();
        this.nombre = paciente.getNombre();
        this.identificacion = paciente.getIdentificacion();
        this.edad = paciente.getEdad();
        this.seguro = paciente.getSeguro();

        this.tipoPaciente = paciente.getTipo();
        this.tipoAtencion = tipoAtencion;
        this.prioridad = prioridad;

        this.fechaIngreso =
                LocalDateTime.now().format(FORMATTER);

        this.fechaAtencion = null;
    }

    /**
     * Marca el paciente como atendido
     */
    public void atender() {
        this.fechaAtencion =
                LocalDateTime.now().format(FORMATTER);
    }

    /**
     * Valida información del tiquete
     */
    public boolean esValido() {

        if (id <= 0) {
            return false;
        }

        if (nombre == null || nombre.isEmpty()) {
            return false;
        }

        if (identificacion == null || identificacion.isEmpty()) {
            return false;
        }

        if (edad <= 0) {
            return false;
        }

        if (seguro == null || seguro.isEmpty()) {
            return false;
        }

        if (tipoAtencion == null ||
                !tipoAtencion.matches("[CSEcse]")) {
            return false;
        }

        if (tipoPaciente == null ||
                !tipoPaciente.matches("[PNpn]")) {
            return false;
        }

        if (prioridad == null) {
            return false;
        }

        return prioridad.equalsIgnoreCase("Critico")
                || prioridad.equalsIgnoreCase("Urgente")
                || prioridad.equalsIgnoreCase("Regular")
                || prioridad.equalsIgnoreCase("Control");
    }

    // ============================================
    // GETTERS
    // ============================================

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getSeguro() {
        return seguro;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getTipoAtencion() {
        return tipoAtencion;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    @Override
    public String toString() {

        return "Tiquete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", ingreso='" + fechaIngreso + '\'' +
                ", atencion='" + fechaAtencion + '\'' +
                '}';
    }
}