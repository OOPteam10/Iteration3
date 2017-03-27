package controller;

import controller.MapMakerControlSubsystem.MMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import controller.MapMakerControlSubsystem.TerrainMMCSubsystem.DesertState;
import model.MapSubsystem.Location;
import model.MapSubsystem.Map;
import model.TileSubsystem.Rivers.River;
import model.TileSubsystem.Terrains.Desert;
import model.TileSubsystem.Terrains.Terrain;
import model.TileSubsystem.Tiles.Tile;
import utilities.TileEditor;

/**
 * Created by rishabh on 26/03/17.
 */
public class MapMakerControl implements ControlHandler{

    //represents state of MapMakerControl
    private MMCState mmcState;

    private Terrain currentTerrain;
    //private Tile tile;
    //private Map map;
    private Location location;

    //public Tile getTile() {return tile;}
    //public void setTile(Tile tile) {this.tile = tile;}

    //constructor
    public MapMakerControl(){
        mmcState = TerrainMMCState.getInstance();
        //this.map = map;
        location = new Location(0, 0, 0);
        TileEditor.getInstance().setLocation(location);
    }

    public MMCState getMmcState() {return mmcState;}
    public void setMmcState(MMCState mmcState) {this.mmcState = mmcState;}
    public Terrain getCurrentTerrain() {return currentTerrain;}
    public void setCurrentTerrain(Terrain currentTerrain) {this.currentTerrain = currentTerrain;}

    public void left(){
        mmcState.left();
    }
    public void right(){
        mmcState.right();
    }
    public void select(Controller controller){
        controller.getControlHandler().getMmcState().select(this);
    }

    public void select(){
        mmcState.select(this);
    }
    public void moveNW(){
        location.addZ(1);
    }
    public void moveN(){
        location.addY(1);
    }
    public void moveNE(){
        location.addX(1);
    }
    public void moveSW(){
        location.addX(-1);
    }
    public void moveS(){
        location.addY(-1);
    }
    public void moveSE(){
        location.addZ(-1);
    }

    //TESTING ONLY
    public void printState(){
        System.out.println("Location: " + location.toString() +
                "State: " + mmcState.toString() + "Substate: ");
        mmcState.printSubState();

    }
    //public void addTileToMap(){
        //map.addTile(tile, location);
    //}

}
