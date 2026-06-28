package cr.ac.ufidelitas.mediqueue.modulo2;

public class PacienteNormal extends Paciente {

    public PacienteNormal(int id, String nombre, String identificacion, int edad, String tipoSeguro) {
        super(id, nombre, identificacion, edad, tipoSeguro);
    }

    @Override
    public String getTipoPaciente() {
        return "N";
    }

    @Override
    public int getNivelPrioridad() {
        return 3; // Regular
    }
}
