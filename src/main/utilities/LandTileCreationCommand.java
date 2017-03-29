package utilities;

import model.MapSubsystem.Map;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Tiles.LandTile;

/**
 * Created by allisonaguirre on 3/29/17.
 */
public class LandTileCreationCommand extends TileCreationCommand {
    Terrain terrain;
    Map map;

    LandTileCreationCommand(Map map, Terrain terrain) {
        this.map = map;
        this.terrain = terrain;
    }

    @Override
    public boolean executeCreation() {
        if (map.addLandTile(new LandTile(terrain), getLocation())) {
            return true;
        } else {
            return false;
        }
    }
}
