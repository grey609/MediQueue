package cr.ac.ufidelitas.mediqueue.modulo3;

public class NodoConsulta {

    private Consulta dato;
    private NodoConsulta siguiente;

    public NodoConsulta() {
    }

    public NodoConsulta(
            Consulta dato) {

        this.dato = dato;
    }

    public Consulta getDato() {
        return dato;
    }

    public void setDato(
            Consulta dato) {

        this.dato = dato;
    }

    public NodoConsulta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(
            NodoConsulta siguiente) {

        this.siguiente = siguiente;
    }
}