package xyz.faewulf.squaremap_area.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import xyz.faewulf.squaremap_area.SquaremapArea;
import xyz.faewulf.squaremap_area.util.SquaremapMarkerManager;
import xyz.faewulf.squaremap_area.util.dataLoader;
import xyz.jpenilla.squaremap.api.Key;
import xyz.jpenilla.squaremap.api.marker.Marker;
import xyz.jpenilla.squaremap.api.marker.MarkerOptions;
import xyz.jpenilla.squaremap.api.marker.Polygon;

import java.awt.*;
import java.util.UUID;

public class onServerStarted {
    public static void load() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> {
            dataLoader.loadData();

            //process data
            if (SquaremapMarkerManager.worlds == null)
                return;

            SquaremapMarkerManager.worlds.forEach((s, world) -> {
                //then forEach every area in the data

                world.Areas.forEach(area -> {
                    try {
                        //obtain server world
                        RegistryKey<World> worldKey = RegistryKey.of(RegistryKeys.WORLD, Identifier.tryParse(world.identifier));
                        ServerWorld serverWorld = server.getWorld(worldKey);

                        //if world is exist then add all area to world
                        if (serverWorld == null)
                            return;


                        //random uuid key
                        UUID uuid = UUID.randomUUID();
                        Key key = Key.of(uuid.toString());

                        Polygon marker = Marker.polygon(area.getPoints());

                        marker.markerOptions(
                                MarkerOptions
                                        .builder()
                                        .fillOpacity(0.4)
                                        .hoverTooltip(area.getName())
                                        .fillColor(Color.decode(area.getColor()))
                                        .stroke(true)
                                        .strokeColor(Color.decode(area.getColor()))
                                        .strokeOpacity(0.7)
                                        .strokeWeight(1)
                        );

                        world.getProvider().addMarker(key, marker);

                    } catch (Exception e) {
                        SquaremapArea.LOGGER.error("Error while parsing '" + area.getName() + "': " + e.toString());
                    }

                });
            });
        }));
    }
}
