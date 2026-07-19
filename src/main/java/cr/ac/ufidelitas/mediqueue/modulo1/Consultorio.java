package cr.ac.ufidelitas.mediqueue.modulo1;

public class Consultorio {

    private int id;
    private String tipo;
    private String especialidad;

    public Consultorio() {
    }

    public Consultorio(int id, String tipo, String especialidad) {
        this.id = id;
        this.tipo = tipo;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Consultorio{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}