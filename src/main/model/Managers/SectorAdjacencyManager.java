package model.Managers;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;

/**
 * Created by hankerins on 4/9/17.
 */
public class SectorAdjacencyManager extends AdjacencyManager<Sector, CardinalDirection, Sector> {

    @Override
    public Adjacency<CardinalDirection, Sector> getAdjacency(Sector l){
        return getManagerMap().get(l);
    }
}
