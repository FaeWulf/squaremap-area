package xyz.faewulf.squaremap_area.util;

import com.google.gson.annotations.SerializedName;
import xyz.jpenilla.squaremap.api.*;

import java.util.ArrayList;
import java.util.List;

public class world {

    public String identifier;
    public String provider;

    @SerializedName("areas")
    public List<Area> Areas = new ArrayList<>();

    public world(String identifier) {
        this.identifier = identifier;
    }

    public void setProvider(SimpleLayerProvider provider, String name) {
        Squaremap api = SquaremapProvider.get();

        api.getWorldIfEnabled(WorldIdentifier.parse(this.identifier)).ifPresent(mapWorld -> {
            Key key = Key.of(name);
            mapWorld.layerRegistry().register(key, provider);
        });

        this.provider = name;
    }

    public SimpleLayerProvider getProvider() {
        Squaremap api = SquaremapProvider.get();
        MapWorld mp = api.getWorldIfEnabled(WorldIdentifier.parse(this.identifier)).orElse(null);
        if (mp != null)
            return (SimpleLayerProvider) mp.layerRegistry().get(Key.of(this.provider));
        return null;
    }

    @Override
    public String toString() {
        return "world{" +
                "identifier='" + identifier + '\'' +
                ", provider='" + provider + '\'' +
                ", areas=" + Areas +
                '}';
    }
}
