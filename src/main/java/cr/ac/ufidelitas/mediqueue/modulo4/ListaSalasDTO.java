package cr.ac.ufidelitas.mediqueue.modulo4;

// DTO de salas
public class ListaSalasDTO {

    private NodoSala inicio;
    private int size;

    public ListaSalasDTO() {
    }

    public NodoSala getInicio() {
        return inicio;
    }

    public void setInicio(
            NodoSala inicio) {

        this.inicio = inicio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}