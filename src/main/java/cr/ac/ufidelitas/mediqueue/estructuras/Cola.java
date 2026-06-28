
package cr.ac.ufidelitas.mediqueue.estructuras;

/**
 * Implementación de Cola usando nodos
 * @param <T>
 */
public class Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    // Insertar (enqueue)
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    // Sacar (dequeue)
    public T desencolar() {
        if (frente == null) return null;

        T dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente == null) fin = null;

        return dato;
    }

    public T verFrente() {
        return (frente != null) ? frente.getDato() : null;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}

