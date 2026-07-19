package cr.ac.ufidelitas.mediqueue.modulo1;

/**
 * Lista enlazada simple de usuarios
 */
public class ListaUsuarios {

    private NodoUsuario inicio;

    public ListaUsuarios() {
        inicio = null;
    }

    /**
     * Agrega usuario al final de la lista
     */
    public void agregar(Usuario usuario) {

        NodoUsuario nuevo =
                new NodoUsuario(usuario);

        if (inicio == null) {
            inicio = nuevo;
            return;
        }

        NodoUsuario actual = inicio;

        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
    }

    /**
     * Busca usuario por credenciales
     */
    public boolean validar(
            String usuario,
            String password) {

        NodoUsuario actual = inicio;

        while (actual != null) {

            Usuario u = actual.getDato();

            if (u.getUsuario().equals(usuario)
                    && u.getPassword().equals(password)) {

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    /**
     * Devuelve el primer nodo para Gson
     */
    public NodoUsuario getInicio() {
        return inicio;
    }

    public void setInicio(NodoUsuario inicio) {
        this.inicio = inicio;
    }
}
