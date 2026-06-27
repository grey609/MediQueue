package cr.ac.ufidelitas.mediqueue.modulo1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfigService {

    private static final String ARCHIVO = "config.json";
    private final Gson gson;

    public ConfigService() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void guardar(Configuracion config) {
        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(config, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Configuracion cargar() {
        try {
            File file = new File(ARCHIVO);
            if (!file.exists()) return null;

            FileReader reader = new FileReader(file);
            return gson.fromJson(reader, Configuracion.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
