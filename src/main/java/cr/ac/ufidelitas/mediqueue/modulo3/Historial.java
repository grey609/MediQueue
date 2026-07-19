package cr.ac.ufidelitas.mediqueue.modulo3;

import cr.ac.ufidelitas.mediqueue.estructuras.Pila;

/**
 * Historial clinico de pacientes
 */
public class Historial {

    private Pila<Consulta> historial;

    /**
     * Constructor
     */
    public Historial() {

        historial = new Pila<>();
    }

    /**
     * Agrega una consulta al historial
     */
    public void agregarConsulta(Consulta consulta) {

        if (consulta != null) {

            historial.push(consulta);
        }
    }

    // Muestra el historial completo
    public void mostrarHistorial() {

        System.out.println(
                "===== HISTORIAL CLINICO =====");

        Pila<Consulta> temporal =
                new Pila<>();

        while (!historial.estaVacia()) {

            Consulta consulta =
                    historial.pop();

            System.out.println(
                    consulta);

            temporal.push(
                    consulta);
        }

        // Restaurar la pila
        while (!temporal.estaVacia()) {

            historial.push(
                    temporal.pop());
        }
    }

    // Convierte la pila a DTO para persistencia JSON
    public HistorialDTO toDTO() {

        HistorialDTO dto =
                new HistorialDTO();

        Pila<Consulta> temporal =
                new Pila<>();

        while (!historial.estaVacia()) {

            Consulta consulta =
                    historial.pop();

            dto.agregar(consulta);

            temporal.push(
                    consulta);
        }

        // Restaurar pila original
        while (!temporal.estaVacia()) {

            historial.push(
                    temporal.pop());
        }

        return dto;
    }

    // Reconstruye la pila desde DTO
    public void fromDTO(
            HistorialDTO dto) {

        if (dto == null) {
            return;
        }

        historial = new Pila<>();

        for (int i = dto.getSize() - 1;
                i >= 0;
                i--) {

            Consulta consulta =
                    dto.get(i);

            if (consulta != null) {

                historial.push(
                        consulta);
            }
        }
    }

    //Devuelve la pila de historial
    public Pila<Consulta> getHistorial() {

        return historial;
    }

    //Reemplaza la pila de historial
    public void setHistorial(
            Pila<Consulta> historial) {

        this.historial = historial;
    }

    //Verifica si el historial esta vacio
    public boolean estaVacio() {

        return historial.estaVacia();
    }
}

