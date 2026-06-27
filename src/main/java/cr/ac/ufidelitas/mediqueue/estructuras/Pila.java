package cr.ac.ufidelitas.mediqueue.estructuras;

public class Pila<T> {

    private Nodo<T> cima;

    public Pila() {
        this.cima = null;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public T pop() {
        if (cima == null) return null;

        T dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }

    public T peek() {
        return (cima != null) ? cima.getDato() : null;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
