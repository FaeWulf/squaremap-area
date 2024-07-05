package xyz.faewulf.squaremap_area.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import xyz.faewulf.squaremap_area.SquaremapArea;
import xyz.jpenilla.squaremap.api.Point;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Map;

public class dataLoader {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Point.class, new PointAdapter())
            .setPrettyPrinting()
            .enableComplexMapKeySerialization()
            .create();

    private static final File DATA_FILE = new File("squaremap/areas.json");

    public static void loadData() {

        Type type = new TypeToken<Map<String, world>>() {
        }.getType();

        DATA_FILE.getParentFile().mkdirs();

        if (DATA_FILE.exists()) {
            try (FileReader reader = new FileReader(DATA_FILE)) {
                SquaremapMarkerManager.worlds = GSON.fromJson(reader, type);
            } catch (Exception e) {
                SquaremapArea.LOGGER.error("Error while reading data: ", e);
            }
        } else {
            try (FileWriter fileWriter = new FileWriter(DATA_FILE)) {
                GSON.toJson(SquaremapMarkerManager.worlds, fileWriter);
            } catch (Exception e) {
                SquaremapArea.LOGGER.error("Error while writing data: ", e);
            }
        }
    }
}
