package cr.ac.ufidelitas.mediqueue.modulo2;

public class PacientePreferencial extends Paciente {

    public PacientePreferencial(int id, String nombre, String identificacion, int edad, String tipoSeguro) {
        super(id, nombre, identificacion, edad, tipoSeguro);
    }

    @Override
    public String getTipoPaciente() {
        return "P";
    }

    @Override
    public int getNivelPrioridad() {
        return 2; // Urgente
    }
}
