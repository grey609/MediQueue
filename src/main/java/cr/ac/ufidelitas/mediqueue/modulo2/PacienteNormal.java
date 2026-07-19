package cr.ac.ufidelitas.mediqueue.modulo2;

public class PacienteNormal extends Paciente {

    public PacienteNormal(int id, String nombre, String identificacion,
                          int edad, String seguro) {

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.seguro = seguro;
    }

    @Override
    public String getTipo() {
        return "N";
    }

    public int getNivelPrioridad() {
        return 3; // Regular
    }
}
