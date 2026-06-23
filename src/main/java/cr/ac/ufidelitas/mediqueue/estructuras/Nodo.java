
package cr.ac.ufidelitas.mediqueue.estructuras;

/**
 * Nodo genérico para estructuras dinámicas
 * @param <T>
 */
public class Nodo<T> {

    public T dato;
    public Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

