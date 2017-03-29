package controller;

import controller.MapMakerControlSubsystem.MMCObserver;
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
import view.View;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class MapMakerControl implements ControlHandler{

    //represents state of MapMakerControl
    private MMCState mmcState;


    private Vector<MMCObserver> mmcObservers;

    //singleton functionality
    private static MapMakerControl instance = new MapMakerControl();
    public static MapMakerControl getInstance(){return instance;}


    //onInit
    public void init(View view){

        mmcObservers.add(view);
    }



    //constructor
    private MapMakerControl(){
        mmcState = TerrainMMCState.getInstance();
        mmcObservers =  new Vector<MMCObserver>();
        TileEditor.getInstance().setLocation(new Location(0,0,0));
    }

    public MMCState getMmcState() {return mmcState;}
    public void setMmcState(MMCState mmcState) {this.mmcState = mmcState;}


    public Vector<MMCObserver> getMmcObservers(){ return mmcObservers;}


    public void left(){
        mmcState.left(mmcObservers);

    }
    public void right(){
        mmcState.right(mmcObservers);
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
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorNW();
        }
    }
    public void moveN(){

        TileEditor.getInstance().moveN();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorN();
        }
    }
    public void moveNE(){

        TileEditor.getInstance().moveNE();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorNE();
        }
    }

    public void moveSW(){

        TileEditor.getInstance().moveSW();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorSW();
        }
    }
    public void moveS(){

        TileEditor.getInstance().moveS();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorS();
        }
    }
    public void moveSE(){

        TileEditor.getInstance().moveSE();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorSE();
        }
    }
    public void delete(){
        TileEditor.getInstance().delete();
    }
    public void reset(){
        mmcState.reset(this);
    }



    //TESTING ONLY
    public void printState(){
        System.out.println("Location: " + TileEditor.getInstance().getLocation().toString() +
                "State: " + mmcState.toString() + "Substate: ");
        mmcState.printSubState();

    }


}
