package cr.ac.ufidelitas.mediqueue.modulo4;

// Nodo para lista enlazada de salas
public class NodoSala {

    private Sala dato;
    private NodoSala siguiente;

    public NodoSala() {
    }

    public NodoSala(Sala dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Sala getDato() {
        return dato;
    }

    public void setDato(Sala dato) {
        this.dato = dato;
    }

    public NodoSala getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSala siguiente) {
        this.siguiente = siguiente;
    }
}