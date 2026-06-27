package cr.ac.ufidelitas.mediqueue.modulo1;

public class Sala {

    private int id;
    private String tipo; // NORMAL, PREFERENCIAL, EMERGENCIA

    public Sala(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
