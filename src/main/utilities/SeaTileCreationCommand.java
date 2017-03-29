package utilities;

import model.MapSubsystem.Map;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.SeaTile;

/**
 * Created by allisonaguirre on 3/29/17.
 */
public class SeaTileCreationCommand extends TileCreationCommand {
    Map map;

    SeaTileCreationCommand(Map map) {
        this.map = map;
    }

    @Override
    public boolean executeCreation() {
        if (map.addSeaTile(new SeaTile(Sea.getInstance()), getLocation())) {
            return true;
        } else {
            return false;
        }
    }
}
