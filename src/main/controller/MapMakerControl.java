package controller;

import controller.Actions.*;
import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.MMCState;
import controller.MapMakerControlSubsystem.TerrainMMCState;
import controller.MovePhaseControlSubsystem.MovePhaseControl;
import javafx.scene.input.KeyCode;
import model.Game;
import model.MapSubsystem.Location;
import utilities.TileEditor;
import view.Camera;
import view.MapMakerPreview;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */
public class MapMakerControl extends ControlHandler {

    //represents state of MapMakerControl
    private MMCState mmcState;


    //mmcobservers
    Vector<MMCObserver> mmcObservers = new Vector<MMCObserver>();

    //singleton functionality
    private static MapMakerControl instance = new MapMakerControl();

    public static MapMakerControl getInstance(){return instance;}


    //onInit
    public void init(Controller controller, Game game, MapMakerPreview preview){

        //camera functionality
        setGame(game);
        setController(controller);

        mmcObservers.add(preview);

    }

    //constructor
    private MapMakerControl(){


        mmcState = TerrainMMCState.getInstance();


        // ADDING ACTIONS SPECIFIC TO MAPMAKERCONTROL

        addAction(new Delete(this), new KeyListener(KeyCode.X));
        addAction(new Reset(this), new KeyListener(KeyCode.C));

       // NOTE : ACTIONS NEXTMODE AND PREVMODE ARE NOT NEEDED FOR MMC

        TileEditor.getInstance().setLocation(new Location(0,0,0));
    }

    public MMCState getMmcState() {return mmcState;}
    public void setMmcState(MMCState mmcState) {this.mmcState = mmcState;}
    public Vector<MMCObserver> getMmcObservers(){return mmcObservers;}

    public void left(){
        System.out.println(mmcObservers.size() + ", "+ mmcObservers);
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
        printState();
    }


    @Override
    public void endTurn() {
        //for testing movement controls
        getGame().startGame();
        getController().changeState(new MovePhaseControl( getController(),getGame()));

    }

    //TODO
    @Override
    public void nextMode() {

    }

    //TODO
    @Override
    public void prevMode() {

    }

    //TODO
    @Override
    public void up() {

    }

    //TODO
    @Override
    public void down() {

    }

    public void delete(){
        TileEditor.getInstance().delete();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).placeTile();
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
