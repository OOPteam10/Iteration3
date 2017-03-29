package utilities;

import controller.MapMakerControlSubsystem.MMCObserver;
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

import java.util.Vector;

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
//    private Tile tile;
    private TileCreationCommand tileCreationCommand;
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
        tileCreationCommand = new LandTileCreationCommand(map, this.terrain);
    }


    public void createRiverTile(River river){
        tileCreationCommand = new RiverTileCreationCommand(map, this.terrain, river);
    }

    public void createSeaTile(){
        tileCreationCommand = new SeaTileCreationCommand(map);
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
    public boolean commit(Vector<MMCObserver> mmcObserverVector) {


        if(mapNotInitialized() || locationNotSet()){
            return false;
        }

        tileCreationCommand.configureLocation(location);
        for(int i=0;i<mmcObserverVector.size();i++){
            mmcObserverVector.get(i).placeTile();
        }

        if (tileCreationCommand.execute()) {
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

    public boolean delete(){
        if(map.remove(location))
            return true;
        else return false;
    }

    public void centerGravity(){
        map.updateCenterOfGravity();
    }

   /*
    //TODO
    @Override
    public void discard() {
        tile = prevTile;
    }
    */
}
