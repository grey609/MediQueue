package cr.ac.ufidelitas.mediqueue.modulo3;

public class HistorialDTO {

    private NodoConsulta inicio;
    private int size;

    public HistorialDTO() {

        inicio = null;
        size = 0;
    }

    public void agregar(Consulta consulta) {

        NodoConsulta nuevo =
                new NodoConsulta(consulta);

        if (inicio == null) {

            inicio = nuevo;

        } else {

            NodoConsulta actual = inicio;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }

        size++;
    }

    public Consulta get(int index) {

        if (index < 0 || index >= size) {
            return null;
        }

        NodoConsulta actual = inicio;

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

    public int getSize() {
        return size;
    }

    public NodoConsulta getInicio() {
        return inicio;
    }

    public void setInicio(
            NodoConsulta inicio) {

        this.inicio = inicio;
    }

    public void setSize(int size) {
        this.size = size;
    }
}