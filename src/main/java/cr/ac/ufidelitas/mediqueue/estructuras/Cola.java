
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

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Sacar (dequeue)
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }

        T dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        Nodo<T> actual = frente;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
