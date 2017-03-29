package utilities;

import model.MapSubsystem.Map;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;

/**
 * Created by allisonaguirre on 3/29/17.
 */
public class RiverTileCreationCommand extends TileCreationCommand {
    Terrain terrain;
    Map map;
    River river;

    RiverTileCreationCommand(Map map, Terrain terrain, River river) {
        this.map = map;
        this.terrain = terrain;
        this.river = river;
    }

    @Override
    public boolean executeCreation() {
        if (map.addRiverTile(new RiverTile(terrain, river), getLocation())) {
            return true;
        } else {
            return false;
        }
    }
}
