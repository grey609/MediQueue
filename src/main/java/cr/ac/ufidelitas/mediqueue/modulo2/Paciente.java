package cr.ac.ufidelitas.mediqueue.modulo2;

public abstract class Paciente implements Priorizable {

    protected int id;
    protected String nombre;
    protected String identificacion;
    protected int edad;
    protected String tipoSeguro;

    public Paciente(int id, String nombre, String identificacion, int edad, String tipoSeguro) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.tipoSeguro = tipoSeguro;
    }

    public abstract String getTipoPaciente();
}
