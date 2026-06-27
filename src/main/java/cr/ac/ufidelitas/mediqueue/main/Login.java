package cr.ac.ufidelitas.mediqueue.main;

public class Login {

    public static boolean autenticar(String usuario, String password) {

        // Usuarios temporales (SIMULACIÓN)
        if (usuario.equals("garias") && password.equals("70021")) return true;
        if (usuario.equals("mchaves") && password.equals("50279")) return true;
        if (usuario.equals("kartavia") && password.equals("80284")) return true;

        return false;
    }
}
