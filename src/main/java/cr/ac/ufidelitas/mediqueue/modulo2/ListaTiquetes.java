package cr.ac.ufidelitas.mediqueue.modulo2;

public class ListaTiquetes {

    public Tiquete[] datos;
    public int size;

    public ListaTiquetes(int capacidad) {
        datos = new Tiquete[capacidad];
        size = 0;
    }

    public void agregar(Tiquete t) {
        if (size < datos.length) {
            datos[size++] = t;
        }
    }
}
