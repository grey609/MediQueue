package cr.ac.ufidelitas.mediqueue.modulo3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;

public class HistorialDAO {

    private final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private static final String ARCHIVO =
            "historial.json";

    public void guardar(
            HistorialDTO dto) {

        try (FileWriter writer =
                     new FileWriter(ARCHIVO)) {

            gson.toJson(dto, writer);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public HistorialDTO cargar() {

        try (FileReader reader =
                     new FileReader(ARCHIVO)) {

            HistorialDTO dto =
                    gson.fromJson(
                            reader,
                            HistorialDTO.class);

            if (dto == null) {
                return new HistorialDTO();
            }

            return dto;

        } catch (Exception e) {

            return new HistorialDTO();
        }
    }
}