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

    private static MapMakerControl instance = new MapMakerControl();
    public static MapMakerControl getInstance(){return instance;}


    //constructor
    private MapMakerControl(){
        mmcState = TerrainMMCState.getInstance();
        TileEditor.getInstance().setLocation(new Location(0,0,0));
    }

    public MMCState getMmcState() {return mmcState;}
    public void setMmcState(MMCState mmcState) {this.mmcState = mmcState;}



    public void left(){
        mmcState.left();
    }
    public void right(){
        mmcState.right();
    }


 /*   public void select(Controller controller){
        controller.getControlHandler().getMmcState().select(this);
    }
*/
    public void select(){
        mmcState.select(this);
    }

    public void moveNW(){

        TileEditor.getInstance().moveNW();
    }
    public void moveN(){

        TileEditor.getInstance().moveN();
    }
    public void moveNE(){

        TileEditor.getInstance().moveNE();
    }

    public void moveSW(){

        TileEditor.getInstance().moveSW();
    }
    public void moveS(){

        TileEditor.getInstance().moveS();
    }
    public void moveSE(){

        TileEditor.getInstance().moveSE();
    }
    

    //TESTING ONLY
    public void printState(){
        System.out.println("Location: " + TileEditor.getInstance().getLocation().toString() +
                "State: " + mmcState.toString() + "Substate: ");
        mmcState.printSubState();

    }


}
