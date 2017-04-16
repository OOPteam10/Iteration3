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


    //singleton functionality
    private static MapMakerControl instance = new MapMakerControl();

    public static MapMakerControl getInstance(){return instance;}


    //onInit
    public void init(Controller controller, Game game, MapMakerPreview preview, Camera camera){

        //camera functionality
        setGame(game);
        setController(controller);
        setCamera(camera);
        setPreview(preview);

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

    public void left(){
        mmcState.left(getMmcObservers());
        //TODO get rid of print
        printState();

    }
    public void right(){
        mmcState.right(getMmcObservers());
        //TODO get rid of print
        printState();
    }


    public void select(){
        mmcState.select(this);
        printState();
    }


    @Override
    public void endTurn() {
        getController().changeState(new MovePhaseControl( getController(),getGame(),getPreview(),getCamera()));
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
        for(int i =0;i<getMmcObservers().size();i++){
            //mmcObservers.get(i).placeTile();
        }

    }
    public void reset(){
        mmcState.reset(this);
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).placeTile();
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



    //TODO delete if not required
      /*
    public void moveNW(){

        TileEditor.getInstance().moveNW();
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).updateCursorNW();
        }
    }
    public void moveN(){

        TileEditor.getInstance().moveN();
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).updateCursorN();
        }
    }
    public void moveNE(){

        TileEditor.getInstance().moveNE();
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).updateCursorNE();
        }
    }

    public void moveSW(){

        TileEditor.getInstance().moveSW();
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).updateCursorSW();
        }
    }
    public void moveS(){

        TileEditor.getInstance().moveS();
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).updateCursorS();
        }
    }
    public void moveSE(){

        TileEditor.getInstance().moveSE();
        for(int i =0;i<getMmcObservers().size();i++){
            getMmcObservers().get(i).updateCursorSE();
        }
    }
*/


}
