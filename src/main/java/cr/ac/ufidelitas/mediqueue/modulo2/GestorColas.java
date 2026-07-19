package cr.ac.ufidelitas.mediqueue.modulo2;

import cr.ac.ufidelitas.mediqueue.estructuras.Cola;

// Gestiona las colas de prioridad del sistema
public class GestorColas {

  
    // COLAS DE PRIORIDAD
    private Cola<Tiquete> colaCriticos = new Cola<>();
    private Cola<Tiquete> colaUrgentes = new Cola<>();
    private Cola<Tiquete> colaRegulares = new Cola<>();
    private Cola<Tiquete> colaControl = new Cola<>();

    // PERSISTENCIA
    private TiqueteDAO dao = new TiqueteDAO();

    // REGISTRAR PACIENTE
    public void registrarPaciente(Tiquete t) {

        if (t == null || !t.esValido()) {

            System.out.println("Tiquete invalido");
            return;
        }

        switch (t.getPrioridad().toUpperCase()) {

            case "CRITICO":
                colaCriticos.encolar(t);
                break;

            case "URGENTE":
                colaUrgentes.encolar(t);
                break;

            case "REGULAR":
                colaRegulares.encolar(t);
                break;

            case "CONTROL":
                colaControl.encolar(t);
                break;

            default:
                colaRegulares.encolar(t);
                break;
        }

        guardarTodo();
    }

    // OBTENER SIGUIENTE PACIENTE
    public Tiquete siguientePaciente() {

        Tiquete t = null;

        if (!colaCriticos.estaVacia()) {

            t = colaCriticos.desencolar();

        } else if (!colaUrgentes.estaVacia()) {

            t = colaUrgentes.desencolar();

        } else if (!colaRegulares.estaVacia()) {

            t = colaRegulares.desencolar();

        } else if (!colaControl.estaVacia()) {

            t = colaControl.desencolar();
        }

        guardarTodo();

        return t;
    }

    // CONVERTIR COLAS A LISTA
    private ListaTiquetes convertirALista() {

        ListaTiquetes lista =
                new ListaTiquetes();

        copiarCola(colaCriticos, lista);
        copiarCola(colaUrgentes, lista);
        copiarCola(colaRegulares, lista);
        copiarCola(colaControl, lista);

        return lista;
    }

    // COPIAR COLA A LISTA
    private void copiarCola(
            Cola<Tiquete> cola,
            ListaTiquetes lista) {

        Cola<Tiquete> temp =
                new Cola<>();

        while (!cola.estaVacia()) {

            Tiquete t =
                    cola.desencolar();

            lista.agregar(t);

            temp.encolar(t);
        }

        while (!temp.estaVacia()) {

            cola.encolar(
                    temp.desencolar());
        }
    }

    // GUARDAR JSON

    public void guardarTodo() {

        ListaTiquetes lista =
                convertirALista();

        dao.guardar(lista);
    }

    // CARGAR JSON

    public void cargarTodo() {

        ListaTiquetes lista =
                dao.cargar();

        if (lista == null) {

            System.out.println(
                    "No hay datos previos");

            return;
        }

        for (int i = 0;
                i < lista.getSize();
                i++) {

            registrarPaciente(
                    lista.get(i));
        }

        System.out.println(
                "Datos cargados");
    }

    // VALIDACIONES

    public boolean estaVacia() {

        return colaCriticos.estaVacia()
                && colaUrgentes.estaVacia()
                && colaRegulares.estaVacia()
                && colaControl.estaVacia();
    }


    // REPORTE DE COLAS
    public void mostrarEstadoColas() {

        System.out.println(
                "Colas cargadas correctamente");
    }
}