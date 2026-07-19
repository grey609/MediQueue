package cr.ac.ufidelitas.mediqueue.modulo4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;

//DAO de salas
public class SalasDAO {

    private final Gson gson;

    private static final String ARCHIVO =
            "salas.json";

    public SalasDAO() {

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void guardar(
            ListaSalas lista) {

        try (FileWriter writer =
                     new FileWriter(ARCHIVO)) {

            gson.toJson(lista, writer);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public ListaSalas cargar() {

        try (FileReader reader =
                     new FileReader(ARCHIVO)) {

            ListaSalas lista =
                    gson.fromJson(
                            reader,
                            ListaSalas.class);

            if (lista == null) {

                return new ListaSalas();
            }

            return lista;

        } catch (Exception e) {

            return new ListaSalas();
        }
    }
}
