package cr.ac.ufidelitas.mediqueue.modulo2;

import cr.ac.ufidelitas.mediqueue.estructuras.Cola;

public class GestorColas {

    private Cola<Tiquete> colaCriticos = new Cola<>();
    private Cola<Tiquete> colaUrgentes = new Cola<>();
    private Cola<Tiquete> colaRegulares = new Cola<>();

    private TiqueteDAO dao = new TiqueteDAO();

    // 🔥 REGISTRAR + GUARDAR AUTOMÁTICO
    public void registrarPaciente(Tiquete t) {

        if (!t.esValido()) {
            System.out.println("Tiquete inválido");
            return;
        }

        switch (t.getPrioridad()) {
            case "Critico":
                colaCriticos.encolar(t);
                break;
            case "Urgente":
                colaUrgentes.encolar(t);
                break;
            default:
                colaRegulares.encolar(t);
        }

        guardarTodo(); // ✅ guarda después de cada inserción
    }

    // 🔥 OBTENER SIGUIENTE
    public Tiquete siguientePaciente() {

        Tiquete t = null;

        if (!colaCriticos.estaVacia()) t = colaCriticos.desencolar();
        else if (!colaUrgentes.estaVacia()) t = colaUrgentes.desencolar();
        else if (!colaRegulares.estaVacia()) t = colaRegulares.desencolar();

        guardarTodo(); // actualizar JSON

        return t;
    }

    // CONVERTIR TODAS LAS COLAS A LISTA
    private ListaTiquetes convertirALista() {

        ListaTiquetes lista = new ListaTiquetes(100);

        copiarCola(colaCriticos, lista);
        copiarCola(colaUrgentes, lista);
        copiarCola(colaRegulares, lista);

        return lista;
    }

    private void copiarCola(Cola<Tiquete> cola, ListaTiquetes lista) {

        Cola<Tiquete> temp = new Cola<>();

        while (!cola.estaVacia()) {
            Tiquete t = cola.desencolar();
            lista.agregar(t);
            temp.encolar(t);
        }

        while (!temp.estaVacia()) {
            cola.encolar(temp.desencolar());
        }
    }

    // ✅ GUARDAR TODO
    public void guardarTodo() {
        ListaTiquetes lista = convertirALista();
        dao.guardar(lista);
    }

    // ✅ CARGAR AL INICIO
    public void cargarTodo() {

        ListaTiquetes lista = dao.cargar();

        if (lista == null) {
            System.out.println("No hay datos previos");
            return;
        }

        for (int i = 0; i < lista.size; i++) {
            registrarPaciente(lista.datos[i]); // reutiliza lógica
        }

        System.out.println("Datos cargados");
    }
}

