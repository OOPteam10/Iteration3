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
    private Location location;

    private Terrain terrain;

    public void init(Map map){
        this.map = map;
        initTile();
    }

    private void initTile(){
        //code for initializing tile, called after every commit and during initialization
        location = new Location(0,0,0);
        //NOW DO NOT NEED TO CREAT A LAND TILE ON INIT
        //tile = new LandTile(Desert.getInstance());

    }

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }

    // method for seting the terrain
    public void setTerrain(Terrain terrain){
        this.terrain = terrain;
    }

    // method to create a land tile directly using the set terrain in the TileEditdor
    public void createLandTile(){
        tile = new LandTile(this.terrain);
    }


    public void createRiverTile(River river){

        tile = new RiverTile(terrain, river);
    }

    public void createSeaTile(){

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
            location = new Location(location);
            return true;
        }
        return false;
    }

    public void moveNW(){
        location.moveNW();
    }
    public void moveN(){
        location.moveN();

    }
    public void moveNE(){
        location.moveNE();

    }
    public void moveSW(){
        location.moveSW();

    }
    public void moveS(){
        location.moveS();

    }
    public void moveSE(){
        location.moveSE();

    }

   /*
    //TODO
    @Override
    public void discard() {
        tile = prevTile;
    }
    */
}
