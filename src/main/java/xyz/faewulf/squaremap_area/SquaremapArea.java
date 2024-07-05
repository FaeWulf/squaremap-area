package xyz.faewulf.squaremap_area;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.faewulf.squaremap_area.event.onServerReload;
import xyz.faewulf.squaremap_area.event.onServerStarted;
import xyz.faewulf.squaremap_area.event.onWorldLoad;

public class SquaremapArea implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("squaremap-area");

    @Override
    public void onInitialize() {
        onWorldLoad.load();
        onServerStarted.load();
        onServerReload.load();
    }
}