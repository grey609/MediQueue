package cr.ac.ufidelitas.mediqueue.modulo1;

public class Configuracion {

    private Sede sede;

    // Usuarios (temporal, luego JSON completo)
    private String[] usuarios;
    private String[] passwords;

    public Configuracion(Sede sede, String[] usuarios, String[] passwords) {
        this.sede = sede;
        this.usuarios = usuarios;
        this.passwords = passwords;
    }

    public Sede getSede() {
        return sede;
    }

    public String[] getUsuarios() {
        return usuarios;
    }

    public String[] getPasswords() {
        return passwords;
    }
}
