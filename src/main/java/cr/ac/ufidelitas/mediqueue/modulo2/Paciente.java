package cr.ac.ufidelitas.mediqueue.modulo2;

public abstract class Paciente {

    protected int id;
    protected String nombre;
    protected String identificacion;
    protected int edad;
    protected String seguro; // INS / CCSS

    // GETTERS (ENCAPSULAMIENTO)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getSeguro() {
        return seguro;
    }

    // POLIMORFISMO
    public abstract String getTipo(); // P o N
}
