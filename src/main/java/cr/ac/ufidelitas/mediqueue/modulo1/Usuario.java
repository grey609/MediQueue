package cr.ac.ufidelitas.mediqueue.modulo1;

/**
 * Representa un usuario del sistema
 */
public class Usuario {

    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return usuario;
    }
}
