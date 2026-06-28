package cr.ac.ufidelitas.mediqueue.persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;

public class Serializacion {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardar(Object obj, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(obj, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T cargar(String archivo, Class<T> clase) {
        try (FileReader reader = new FileReader(archivo)) {
            return gson.fromJson(reader, clase);
        } catch (Exception e) {
            return null;
        }
    }
}

