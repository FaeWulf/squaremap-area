package xyz.faewulf.squaremap_area.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import xyz.jpenilla.squaremap.api.Point;

import java.io.IOException;

public class PointAdapter extends TypeAdapter<Point> {

    @Override
    public void write(JsonWriter out, Point point) throws IOException {
        out.beginObject();
        out.name("x").value(point.x());
        out.name("z").value(point.z());
        out.endObject();
    }

    @Override
    public Point read(JsonReader in) throws IOException {
        double x = 0;
        double z = 0;

        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();
            switch (name) {
                case "x":
                    x = in.nextDouble();
                    break;
                case "z":
                    z = in.nextDouble();
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return Point.of(x, z);
    }
}
