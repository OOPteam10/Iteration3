package model.Managers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;

/**
 * Created by hankerins on 4/9/17.
 */
public class WaterwayAdjacencyManager extends AdjacencyManager<Waterway, HexSide, Waterway> {
    @Override
    public Adjacency<HexSide, Waterway> getAdjacency(Waterway l){
        return getManagerMap().get(l);
    }
}
