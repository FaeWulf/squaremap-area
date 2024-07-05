package xyz.faewulf.squaremap_area.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import xyz.faewulf.squaremap_area.util.SquaremapMarkerManager;
import xyz.faewulf.squaremap_area.util.world;
import xyz.jpenilla.squaremap.api.SimpleLayerProvider;
import xyz.jpenilla.squaremap.api.Squaremap;
import xyz.jpenilla.squaremap.api.SquaremapProvider;
import xyz.jpenilla.squaremap.api.WorldIdentifier;

public class onWorldLoad {
    public static void load() {
        ServerWorldEvents.LOAD.register(
                (server, world_) -> {
                    //get world id: example minecraft:the_end
                    String worldKey = world_.getRegistryKey().getValue().toString();

                    //get sqrmap api
                    Squaremap api = SquaremapProvider.get();

                    //get mapworld based on id
                    api.getWorldIfEnabled(WorldIdentifier.parse(worldKey)).ifPresent(mapWorld -> {

                        //create new world obj
                        world worldObj = new world(mapWorld.identifier().asString());

                        SimpleLayerProvider provider = SimpleLayerProvider.builder("Area")
                                .showControls(true)
                                .defaultHidden(false)
                                .layerPriority(5)
                                .zIndex(250)
                                .build();

                        //set provider
                        worldObj.setProvider(provider, "area_" + mapWorld.identifier().namespace());

                        //then put into manager
                        SquaremapMarkerManager.worlds.put(worldKey, worldObj);
                    });
                }
        );
    }
}
