package utilities;

import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Terrains.Desert;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Tiles.LandTile;
import model.TileSubsystem.Tiles.RiverTile;
import model.TileSubsystem.Tiles.SeaTile;
import model.TileSubsystem.Tiles.Tile;

/**
 * Created by cduica on 3/27/17.
 */
public class TileEditor implements Editor{
    //Singleton shizz
    private static TileEditor ourInstance = new TileEditor();

    public static TileEditor getInstance() {
        return ourInstance;
    }

    private TileEditor() {
    }

    private Map map;
    private Tile tile;
    private Tile prevTile;
    private Location location;

    public void init(Map map){
        this.map = map;
        initTile();
    }

    private void initTile(){
        //code for initializing tile, called after every commit and during initialization
        tile = new LandTile(Desert.getInstance());
        prevTile = tile;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void createLandTile(Terrain terrain){
        prevTile = tile;
        tile = new LandTile(terrain);
    }

    public void createRiverTile(River river){
        prevTile = tile;
        tile = new RiverTile(tile.getTerrain(), river);
    }

    public void createSeaTile(){
        prevTile = tile;
        tile = new SeaTile(Sea.getInstance());
    }


    public boolean mapNotInitialized(){
        if(map == null){
            return true;
        }
        return false;
    }

    public boolean locationNotSet(){
        if(location == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean commit() {

        if(mapNotInitialized() || locationNotSet()){
            return false;
        }

        if(map.addTile(tile, location)){
            initTile();
            return true;
        }
        return false;
    }

    //TODO
    @Override
    public void discard() {
        tile = prevTile;
    }
}
