package controller;

import controller.Actions.*;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.MMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import javafx.scene.input.KeyCode;
import model.MapSubsystem.Location;
import utilities.TileEditor;
import view.MapMakerPreview;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class MapMakerControl extends ControlHandler {

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
    }


    //constructor
    private MapMakerControl(){

        mmcState = TerrainMMCState.getInstance();
        mmcObservers =  new Vector<MMCObserver>();

        // ADDING ACTIONS SPECIFIC TO MAPMAKERCONTROL

        addAction(new CycleLeft(this), new KeyListener(KeyCode.LEFT));
        addAction(new CycleRight(this), new KeyListener(KeyCode.RIGHT));
        addAction(new Delete(this), new KeyListener(KeyCode.X));
        addAction(new Reset(this), new KeyListener(KeyCode.C));
        addAction(new MoveNorth(this), new KeyListener(KeyCode.W));
        addAction(new MoveNW(this), new KeyListener(KeyCode.Q));
        addAction(new MoveNE(this), new KeyListener(KeyCode.E));
        addAction(new MoveSouth(this), new KeyListener(KeyCode.S));
        addAction(new MoveSW(this), new KeyListener(KeyCode.A));
        addAction(new MoveSE(this), new KeyListener(KeyCode.D));
        addAction(new Select(this), new KeyListener(KeyCode.ENTER));

       // NOTE : ACTIONS NEXTMODE AND PREVMODE ARE NOT NEEDED FOR MMC

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

    //TODO
    @Override
    public void nextMode() {

    }

    //TODO
    @Override
    public void prevMode() {

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
