package model.TileSubsystem.Tiles;

import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.HexSide;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Visitor.TileVisitor;

import javax.smartcardio.Card;
import java.util.ArrayList;

/**
 * Created by hankerins on 3/26/17.
 */
public abstract class Tile {
    private CardinalDirection[] halfEdges = CardinalDirection.values();
    private Terrain terrain;
    private ArrayList<Sector> sectors;
    private HexSide[] sides = HexSide.values();


    public void setTerrain(Terrain terrain) {this.terrain = terrain;}


    public abstract void accept(TileVisitor v);
    public Terrain getTerrain(){return terrain;}
    public CardinalDirection[] getHalfEdges() {return halfEdges;}
    public ArrayList<Sector> getSectors() {return sectors;}
    public HexSide[] getSides() {return sides;}
}
