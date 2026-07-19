package cr.ac.ufidelitas.mediqueue.modulo4;

import cr.ac.ufidelitas.mediqueue.modulo2.Tiquete;

public class GestorSalas {

    private ListaSalas lista;

    public GestorSalas() {

        lista = new ListaSalas();

        // creación de salas (puedes modificar capacidad)
        lista.agregarSala(new Sala(1, 5, "Dr. A", "Enf. A"));
        lista.agregarSala(new Sala(2, 5, "Dr. B", "Enf. B"));
        lista.agregarSala(new Sala(3, 5, "Dr. C", "Enf. C"));
    }

    // BUSCAR SALA CON MENOR CARGA
    private Sala buscarSalaDisponible() {

        Sala mejor = null;

        for (int i = 0; i < lista.getSize(); i++) {

            Sala actual = lista.getSala(i);

            if (!actual.hayEspacio()) continue;

            if (mejor == null) {
                mejor = actual;
            } else if (actual.getCantidadPacientes() < mejor.getCantidadPacientes()) {
                mejor = actual;
            }
        }

        return mejor;
    }

    // ASIGNAR PACIENTE A SALA
    public void asignarPaciente(Tiquete t) {

        // críticos no pasan por salas
        if (t.getPrioridad().equalsIgnoreCase("Critico")) {
            System.out.println("⚠ Paciente crítico no se envía a sala");
            return;
        }

        Sala s = buscarSalaDisponible();

        if (s == null) {
            System.out.println("No hay espacio en salas");
            return;
        }

        s.agregarPaciente(t);

        System.out.println("Paciente asignado a Sala " + s.getId());
    }

    // ATENDER Y RETORNAR PACIENTE (IMPORTANTE PARA MAIN)
    public Tiquete atenderYRetornar(int id) {

        Sala s = lista.getSala(id - 1);

        if (s == null) {
            System.out.println("Sala no existe");
            return null;
        }

        if (s.estaVacia()) {
            System.out.println("Sala vacía");
            return null;
        }

        return s.atender();
    }

    // VALIDACIÓN GLOBAL
    public boolean salasVacias() {

        for (int i = 0; i < lista.getSize(); i++) {
            if (!lista.getSala(i).estaVacia()) {
                return false;
            }
        }

        return true;
    }

    // VISUALIZACIÓN
    public void mostrarSalas() {

        System.out.println("\n=== ESTADO DE SALAS ===");

        for (int i = 0; i < lista.getSize(); i++) {

            Sala s = lista.getSala(i);

            System.out.println(
                "Sala " + s.getId() +
                " | Pacientes: " + s.getCantidadPacientes() +
                "/" + s.getCapacidad()
            );
        }
    }
}
