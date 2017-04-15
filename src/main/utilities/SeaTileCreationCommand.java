package utilities;

import model.MapSubsystem.Map;
import model.TileSubsystem.Terrains.Sea;
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
        return map.addSeaTile(new SeaTile(Sea.getInstance()), getLocation());
    }
}
