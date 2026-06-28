package cr.ac.ufidelitas.mediqueue.modulo2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;

public class TiqueteDAO {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String ARCHIVO = "tiquetes.json";

    public void guardar(ListaTiquetes lista) {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListaTiquetes cargar() {
        try (FileReader reader = new FileReader(ARCHIVO)) {
            return gson.fromJson(reader, ListaTiquetes.class);
        } catch (Exception e) {
            return null;
        }
    }
}
