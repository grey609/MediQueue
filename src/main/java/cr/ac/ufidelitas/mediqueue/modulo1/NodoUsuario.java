package cr.ac.ufidelitas.mediqueue.modulo1;

/**
 * Nodo para lista enlazada de usuarios
 */
public class NodoUsuario {

    private Usuario dato;
    private NodoUsuario siguiente;

    public NodoUsuario(Usuario dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Usuario getDato() {
        return dato;
    }

    public NodoUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUsuario siguiente) {
        this.siguiente = siguiente;
    }
}
