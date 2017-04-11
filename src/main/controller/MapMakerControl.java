package controller;

import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.MMCState;
import controller.MapMakerControlSubsystem.MapMakerControlHandler;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import model.MapSubsystem.Location;
import utilities.TileEditor;
import view.MapMakerPreview;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class MapMakerControl extends MapMakerControlHandler {

    //represents state of MapMakerControl
    private MMCState mmcState;

    //list of observers
    private Vector<MMCObserver> mmcObservers;


    //singleton functionality
    private static MapMakerControl instance = new MapMakerControl();
    public static MapMakerControl getInstance(){return instance;}


    //onInit
    public void init(MapMakerPreview preview){
        mmcObservers.add(preview);
        addToKLSet();
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
        //TODO get rid of print
        printState();

    }
    public void right(){
        mmcState.right(mmcObservers);
        //TODO get rid of print
        printState();
    }



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
        for(int i =0;i<mmcObservers.size();i++){
            //mmcObservers.get(i).placeTile();
        }

    }
    public void reset(){
        mmcState.reset(this);
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).placeTile();
        }
    }

    public void centerGravity(){
        TileEditor.getInstance().centerGravity();
    }


    //TESTING ONLY
    public void printState(){
        System.out.println("Location: " + TileEditor.getInstance().getLocation().toString() +
                "State: " + mmcState.toString() + "Substate: ");
        mmcState.printSubState();
    }
}
