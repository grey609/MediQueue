package cr.ac.ufidelitas.mediqueue.modulo1;

public class Configuracion {

    private Sede sede;

    private ListaUsuarios usuarios;

    private Sala salaPreferencial;
    private Sala salaEmergenciaCritica;

    private Consultorio consultorioPreferencial;

    public Configuracion() {
    }

    public Configuracion(
            Sede sede,
            ListaUsuarios usuarios,
            Sala salaPreferencial,
            Sala salaEmergenciaCritica,
            Consultorio consultorioPreferencial) {

        this.sede = sede;
        this.usuarios = usuarios;
        this.salaPreferencial = salaPreferencial;
        this.salaEmergenciaCritica = salaEmergenciaCritica;
        this.consultorioPreferencial = consultorioPreferencial;
    }

    public Sede getSede() {
        return sede;
    }

    public ListaUsuarios getUsuarios() {
        return usuarios;
    }

    public Sala getSalaPreferencial() {
        return salaPreferencial;
    }

    public Sala getSalaEmergenciaCritica() {
        return salaEmergenciaCritica;
    }

    public Consultorio getConsultorioPreferencial() {
        return consultorioPreferencial;
    }
}
