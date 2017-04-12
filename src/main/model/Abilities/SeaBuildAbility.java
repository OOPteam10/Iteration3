package model.Abilities;

import model.Managers.SeaProducerOccupancyManager;
import model.TileSubsystem.Tiles.SeaTile;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class SeaBuildAbility implements BuildAbility {
    public abstract void execute(SeaTile s, SeaProducerOccupancyManager som);
}
