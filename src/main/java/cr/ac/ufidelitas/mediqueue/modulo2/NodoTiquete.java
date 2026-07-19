package cr.ac.ufidelitas.mediqueue.modulo2;

public class NodoTiquete {

    private Tiquete dato;
    private NodoTiquete siguiente;

    public NodoTiquete() {
    }

    public NodoTiquete(Tiquete dato) {

        this.dato = dato;
        this.siguiente = null;
    }

    public Tiquete getDato() {
        return dato;
    }

    public void setDato(Tiquete dato) {
        this.dato = dato;
    }

    public NodoTiquete getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTiquete siguiente) {
        this.siguiente = siguiente;
    }
}
