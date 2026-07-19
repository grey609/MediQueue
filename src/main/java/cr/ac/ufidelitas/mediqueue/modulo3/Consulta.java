package cr.ac.ufidelitas.mediqueue.modulo3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {

    private int idTiquete;
    private String medico;
    private String diagnostico;
    private String observaciones;
    private String estado;
    private String fecha;

    public Consulta(int idTiquete, String medico) {

        this.idTiquete = idTiquete;
        this.medico = medico;
        this.estado = "EN_ATENCION";

        // FORMATO BONITO
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        this.fecha = LocalDateTime.now().format(formatter);
    }

    public void finalizar(String diagnostico, String observaciones) {
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.estado = "FINALIZADO";
    }

    public void cancelar() {
        this.estado = "CANCELADO";
    }

    // GETTERS
    public int getIdTiquete() {
        return idTiquete;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "tiquete=" + idTiquete +
                ", medico='" + medico + '\'' +
                ", estado='" + estado + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}