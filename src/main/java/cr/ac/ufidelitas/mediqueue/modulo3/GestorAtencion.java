package cr.ac.ufidelitas.mediqueue.modulo3;

import cr.ac.ufidelitas.mediqueue.modulo2.*;

public class GestorAtencion {

    private GestorColas gestorColas;
    private Historial historial;
    private HistorialDAO dao;

    public GestorAtencion(GestorColas gestorColas) {
        this.gestorColas = gestorColas;
        this.historial = new Historial();
        this.dao = new HistorialDAO();

        cargarHistorial();
    }

    // ATENCIÓN AUTOMÁTICA (desde cola)
    public void atenderPaciente(String medico) {

        Tiquete t = gestorColas.siguientePaciente();

        if (t == null) {
            System.out.println("No hay pacientes");
            return;
        }

        // Marcar como atendido
        t.atender();

        // Crear consulta
        Consulta consulta = new Consulta(t.getId(), medico);

        System.out.println("Atendiendo: " + t);

        // Finalizar consulta
        consulta.finalizar("Diagnóstico general", "Sin observaciones");

        // Guardar en historial (PILA)
        historial.agregarConsulta(consulta);

        // Persistencia
        guardarHistorial();

        System.out.println(" Consulta guardada");
    }

    // NUEVO MÉTODO (CORRECCIÓN CRÍTICA)
    public void registrarConsulta(Tiquete t, String medico) {

        // Validación
        if (t == null || !t.esValido()) {
            System.out.println("Tiquete inválido");
            return;
        }

        // Marcar como atendido
        t.atender();

        // Crear consulta
        Consulta consulta = new Consulta(t.getId(), medico);

        System.out.println("Registrando consulta para: " + t);

        // Finalizar consulta
        consulta.finalizar("Diagnóstico general", "Sin observaciones");

        // Agregar a historial
        historial.agregarConsulta(consulta);

        // Persistencia
        guardarHistorial();

        System.out.println("Consulta registrada correctamente");
    }

    // MOSTRAR HISTORIAL
    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    // GUARDADO JSON
    private void guardarHistorial() {
        dao.guardar(historial.toDTO());
    }

    // CARGA JSON
    private void cargarHistorial() {

        HistorialDTO dto = dao.cargar();

        if (dto != null) {
            historial.fromDTO(dto);
            System.out.println("Historial cargado");
        } else {
            System.out.println("No existe historial previo");
        }
    }
}
