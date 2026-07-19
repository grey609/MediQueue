package cr.ac.ufidelitas.mediqueue.modulo2;

/**
 * Lista enlazada de Tiquetes
 * Reemplaza el arreglo Tiquete[]
 */
public class ListaTiquetes {

    private NodoTiquete inicio;
    private int size;

    // Constructor
    
    public ListaTiquetes() {

        inicio = null;
        size = 0;
    }

    //Agregar al final de la lista
    
    public void agregar(Tiquete t) {

        NodoTiquete nuevo =
                new NodoTiquete(t);

        if (inicio == null) {

            inicio = nuevo;

        } else {

            NodoTiquete actual = inicio;

            while (actual.getSiguiente() != null) {

                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }

        size++;
    }

    // Obtiene un elemento por posicion
    
    public Tiquete get(int index) {

        if (index < 0 || index >= size) {
            return null;
        }

        NodoTiquete actual = inicio;

        int contador = 0;

        while (actual != null) {

            if (contador == index) {
                return actual.getDato();
            }

            contador++;

            actual = actual.getSiguiente();
        }

        return null;
    }

    //Buscar por ID de tiquete
    
    public Tiquete buscarPorId(int id) {

        NodoTiquete actual = inicio;

        while (actual != null) {

            if (actual.getDato().getId() == id) {

                return actual.getDato();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    // Verifica si la lista esta vacia
     
    public boolean estaVacia() {

        return inicio == null;
    }

    // Cantidad de elementos
    
    public int getSize() {

        return size;
    }

    public void setSize(int size) {

        this.size = size;
    }

    // Primer nodo de la lista
     
    public NodoTiquete getInicio() {

        return inicio;
    }

    public void setInicio(NodoTiquete inicio) {

        this.inicio = inicio;
    }

    // Mostrar lista completa
    
    public void mostrar() {

        NodoTiquete actual = inicio;

        while (actual != null) {

            System.out.println(
                    actual.getDato());

            actual = actual.getSiguiente();
        }
    }

    @Override
    public String toString() {

        String texto = "";

        NodoTiquete actual = inicio;

        while (actual != null) {

            texto += actual.getDato() + "\n";

            actual = actual.getSiguiente();
        }

        return texto;
    }
}