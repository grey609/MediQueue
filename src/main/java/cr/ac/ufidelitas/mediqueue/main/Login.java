package cr.ac.ufidelitas.mediqueue.main;

import cr.ac.ufidelitas.mediqueue.modulo1.Configuracion;

public class Login {

    public static boolean autenticar(
            String usuario,
            String password,
            Configuracion config) {

        if (config == null) {
            return false;
        }

        return config.getUsuarios()
                .validar(usuario, password);
    }
}