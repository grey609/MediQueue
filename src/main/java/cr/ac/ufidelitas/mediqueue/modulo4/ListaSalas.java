package cr.ac.ufidelitas.mediqueue.modulo4;

//Lista enlazada de salas
public class ListaSalas {

    private NodoSala inicio;
    private int size;

    public ListaSalas() {

        inicio = null;
        size = 0;
    }

    // Agrega una sala al final
    public void agregarSala(Sala sala) {

        NodoSala nuevo =
                new NodoSala(sala);

        if (inicio == null) {

            inicio = nuevo;

        } else {

            NodoSala actual = inicio;

            while (actual.getSiguiente() != null) {

                actual =
                        actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }

        size++;
    }

    // Obtiene sala por posicion
    public Sala getSala(int index) {

        if (index < 0 || index >= size) {

            return null;
        }

        NodoSala actual = inicio;

        int contador = 0;

        while (actual != null) {

            if (contador == index) {

                return actual.getDato();
            }

            contador++;

            actual =
                    actual.getSiguiente();
        }

        return null;
    }

    public int getSize() {

        return size;
    }

    public void setSize(int size) {

        this.size = size;
    }

    public NodoSala getInicio() {

        return inicio;
    }

    public void setInicio(
            NodoSala inicio) {

        this.inicio = inicio;
    }
}
